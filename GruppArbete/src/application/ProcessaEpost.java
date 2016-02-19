package application;

import java.sql.CallableStatement;
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
	private CallableStatement cStmt;
	private Statement stmt;
	private ResultSet rs;
	private Timer timer;
	private int count;

	public ProcessaEpost() {
		connection = null;
		stmt = null;
		rs = null;
		cStmt = null;
		count = 0;
	}

	private void skickaEpost() throws SQLException {
		try {
			if (this.connection == null) {
				connection = Model.MODEL.getConnection();
			}
			if (connection != null) {
				cStmt = connection.prepareCall("{call arkiveraAuktion}");
				if (cStmt.execute()) {
					System.out.println("arkiveraAuktion anropat");
				}
				stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				rs = stmt.executeQuery("select * from epost where `status` = 'k�at'");
				rs.beforeFirst();
				while (rs.next()) {
					String mottagare = rs.getString("mottagare");
					String inneh�ll = rs.getString("inneh�ll");
					String �mne = rs.getString("�mne");
					this.composeEmail(mottagare, inneh�ll, �mne);
				}
				String sql = "update epost set `status` = 'skickat' where `status` = 'k�at' ";
				stmt.executeUpdate(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (cStmt != null)
				cStmt.close();
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		}
	}

	private void composeEmail(String mottagare, String inneh�ll, String �mne) {
		String from = USER_NAME;
		String pass = PASSWORD;
		String to = mottagare;
		String subject = �mne;
		String body = inneh�ll;
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
			InternetAddress toAddress = new InternetAddress(to);
			message.addRecipient(Message.RecipientType.TO, toAddress);
			message.setSubject(subject);
			message.setText(body);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (AddressException ae) {
			ae.printStackTrace();
		} catch (MessagingException me) {
			me.printStackTrace();
		}
	}

	public void startTask() {
		System.out.println("Timer task started at:" + new Date());
		this.connection = Model.MODEL.getConnection();
		timer = new Timer(false);
		timer.scheduleAtFixedRate(this, 0, 2 * 60000);// run every 2 minute
	}

	@Override
	public void run() {
		count++;
		if (count >= 6) { //Just for demonstration purposes - task only runs for 12 minutes.
			timer.cancel();
			timer.purge();
			return;
		} else {
			try {
				skickaEpost();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
