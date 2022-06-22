/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Message;
import model.User;

/**
 *
 * @author Administrator
 */
public class MessengerDAO {

    DBConnect mysqlConnect = new DBConnect();

    public void addMessage(String content, String fromid, String toid, String sendTime) {
        try {
            String sql = "INSERT INTO `messengers` (`content`, `fromID`, `toID`, `sendTime`) VALUES\n"
                    + "(?,?,?,?)";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, content);
            statement.setString(2, fromid);
            statement.setString(3, toid);
            statement.setString(4, sendTime);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MessengerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<User> getMesstoAdmin(String adminID) {
        ArrayList<User> list = new ArrayList<>();
        try {
            String sql = "SELECT  DISTINCT infUSER.* FROM\n"
                    + "(SELECT DISTINCT user_accounts.* from messengers INNER JOIN user_accounts ON user_accounts.user_id = messengers.fromID WHERE messengers.toID = ? ) as listUSERsend INNER join\n" // ? in this line
                    + "(SELECT user_id,user_name,`password`,first_name,middle_name,last_name,gender,telephone as phone,email,status_id FROM\n"
                    + "(SELECT ua.*, ac.* FROM user_address AS ua INNER JOIN user_accounts as ac \n"
                    + " ON ua.userID = ac.user_id) AS rs1\n"
                    + "INNER JOIN electronicaddress AS ea ON ea.eaID = rs1.eaID) as infUSER WHERE infUSER.user_id = listUSERsend.user_id";

            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, adminID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User u = new User();

                u.setUserid(rs.getInt("user_id"));
                u.setUsername(rs.getString("user_name"));
                u.setPassword(rs.getString("password"));
                u.setFirstname(rs.getString("first_name"));
                u.setMiddlename(rs.getString("middle_name"));
                u.setLastname(rs.getString("last_name"));
                u.setGender(rs.getInt("gender"));
                u.setPhone(rs.getString("phone"));
                u.setEmail(rs.getString("email"));
                u.setStatus(rs.getInt("status_id"));
                list.add(u);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(MessengerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public ArrayList<Message> getAllMessageofUser(String groupID, String userID) {
        ArrayList<Message> list = new ArrayList<>();
        try {
            String sql = "SELECT rs1.* FROM\n"
                    + "(SELECT mess.messageID,creatorID,recipientGroupID,messageBody,createDate,isRead FROM messages AS mess INNER JOIN message_recipient AS mr \n"
                    + "ON mess.messageID = mr.messageID) as rs1 INNER JOIN \n"
                    + "(SELECT ug.groupID,ug.userID FROM `group` INNER JOIN user_group AS ug ON ug.groupID = `group`.groupID\n"
                    + "WHERE ug.groupID = ? AND userID = ?)as rs2\n"
                    + "ON rs1.recipientGroupID = rs2.groupID ";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, groupID);
            statement.setString(2, userID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Message s = new Message();
                s.setId(rs.getString("messageID"));
                s.setFromID(rs.getString("creatorID"));
                s.setToID(rs.getString("recipientGroupID"));
                s.setContent(rs.getString("messageBody"));
                s.setCreateDate(rs.getString("createDate"));
                s.setIsread(rs.getString("isRead"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessengerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return list;
    }

    public Message getLastMessage(String groupID, String userID) {
        Message s = new Message();
        try {
            String sql = "SELECT  * FROM\n"
                    + "(SELECT rs1.* FROM\n"
                    + "(SELECT mess.messageID,creatorID,recipientGroupID,messageBody,createDate,isRead FROM messages AS mess INNER JOIN message_recipient AS mr \n"
                    + "ON mess.messageID = mr.messageID ) as rs1 INNER JOIN \n"
                    + "(SELECT ug.groupID,ug.userID FROM `group` INNER JOIN user_group AS ug ON ug.groupID = `group`.groupID\n"
                    + "WHERE ug.groupID = ? AND userID = ?)as rs2\n"
                    + "ON rs1.recipientGroupID = rs2.groupID) AS rs3 \n"
                    + "\n"
                    + "WHERE messageID = \n"
                    + "(SELECT MAX(messageID) FROM\n"
                    + "(SELECT mess.messageID,creatorID,recipientGroupID,messageBody,createDate,isRead FROM messages AS mess INNER JOIN message_recipient AS mr \n"
                    + "ON mess.messageID = mr.messageID ) as rs1 INNER JOIN \n"
                    + "(SELECT ug.groupID,ug.userID FROM `group` INNER JOIN user_group AS ug ON ug.groupID = `group`.groupID\n"
                    + "WHERE ug.groupID = ? AND userID = ?)as rs2\n"
                    + "ON rs1.recipientGroupID = rs2.groupID) ";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, groupID);
            statement.setString(2, userID);
            statement.setString(3, groupID);
            statement.setString(4, userID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                s.setId(rs.getString("messageID"));
                s.setFromID(rs.getString("creatorID"));
                s.setToID(rs.getString("recipientGroupID"));
                s.setContent(rs.getString("messageBody"));
                s.setCreateDate(rs.getString("createDate"));
                s.setIsread(rs.getString("isRead"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(MessengerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return s;
    }

    // add message
    //sửa addRecipientMessage!!!
    public void addRecipientMessage( String recipientGroupID,String messageID) {
        String sql = "INSERT INTO message_recipient(recipientGroupID,messageID) VALUES\n"
                + "(?,?)";

        try {
            PreparedStatement ps = mysqlConnect.connect().prepareStatement(sql);
            ps.setString(1, recipientGroupID);
            ps.setString(2, messageID);
            
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public static void main(String[] args) {
        MessengerDAO m = new MessengerDAO();
        ArrayList<Message> list = m.getAllMessageofUser("1", "3");
        for (Message message : list) {
            System.out.println(message.getContent());
        }
    }
}
