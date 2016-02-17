package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class ProcessaEpost extends TimerTask {
	private static String USER_NAME = "nackademiskaauktion"; 
    private static String PASSWORD = "Gunnar4president";
	private Connection connection;
	private Statement stmt;
	private ResultSet rs;

	public ProcessaEpost() {
		connection = null;
		stmt = null;
		rs = null;
	}
	
	private void skickaEpost() throws SQLException {
		try {
			if (this.connection == null) {
				connection = Model.MODEL.getConnection();
			}
			if (connection != null) {
				stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				rs = stmt.executeQuery("select * from epost where `status` = 'köat'");
				rs.beforeFirst();
				while (rs.next()) {
					String mottagare = rs.getString("mottagare");
					String innehåll = rs.getString("innehåll");
					String ämne = rs.getString("ämne");
					this.composeEmail(mottagare,innehåll,ämne);
				}
				String sql = "update epost set `status` = 'skickat' where `status` = 'köat' ";
				stmt.executeUpdate(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			rs.close();
		}
	}
	
	private void composeEmail(String mottagare, String innehåll, String ämne){
		String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = { mottagare };
        String subject = ämne;
        String body = innehåll;
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
	}
	
	public void startTask(){
		System.out.println("Timer task started at:" + new Date());
		this.connection = Model.MODEL.getConnection();
		Timer timer = new Timer(false);
		timer.scheduleAtFixedRate(this, 0, 3 * 60000);// run every 3 minutes
	}

	@Override
	public void run() {
		try {
			skickaEpost();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
