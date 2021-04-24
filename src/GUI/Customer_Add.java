package GUI;

import BackendCode.Customer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class Customer_Add {

    JButton Add_Button, Cancel_Button;
    JLabel Name_Label,Address_Label,Password_Label;
    JLabel CNIC_Label,  Contact_Label, Email_Label, UserName_Label,  CNICValidity_Label, contactValidity_Label, NameValidity_Label, AddressValidity_Label, UserNameValidity_Label, PasswordValidity_Label;
    JTextField CNIC_TextField, Name_TextField, Contact_TextField, Address_TextField, UserName_TextField, Password_TextField;
    JFrame frame = new JFrame();

    public Customer_Add() {
        frame.setTitle("Add Customer");
        frame.setLayout(new AbsoluteLayout());
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Parent_JFrame.getMainFrame().setEnabled(true);
                frame.dispose();
            }
        });

        frame.setSize(new Dimension(450, 290));
        frame.setResizable(false);
        frame.setLocationRelativeTo(Parent_JFrame.getMainFrame());

        Add_Button = new JButton("Add");
        Cancel_Button = new JButton("Cancel");

//        CNIC_Label = new JLabel("Enter CNIC (without dashes)");
        Name_Label = new JLabel("Enter Name");
//        Phone_label = new JLabel("Enter Phone");

        Contact_Label = new JLabel("Enter Contact");
        Address_Label = new JLabel("Enter Address");
//        UserName_Label = new JLabel("Enter Username");
        Password_Label = new JLabel("Enter Password");
        
//        CNICValidity_Label = new JLabel();
        NameValidity_Label = new JLabel();
        AddressValidity_Label = new JLabel();
//        UserNameValidity_Label = new JLabel();
        PasswordValidity_Label = new JLabel();
        contactValidity_Label = new JLabel();
        
//        CNIC_TextField = new JTextField();
        Name_TextField = new JTextField();
        Contact_TextField = new JTextField();
        Address_TextField = new JTextField();
//        UserName_TextField = new JTextField();
        Password_TextField = new JTextField();

//        CNIC_TextField.setPreferredSize(new Dimension(240, 22));
        Name_TextField.setPreferredSize(new Dimension(240, 22));
        Contact_TextField.setPreferredSize(new Dimension(240, 22));
        Address_TextField.setPreferredSize(new Dimension(240, 22));
//        UserName_TextField.setPreferredSize(new Dimension(240, 22));
        Password_TextField.setPreferredSize(new Dimension(240, 22));

//        CNIC_Label.setPreferredSize(new Dimension(175, 22));
        Name_Label.setPreferredSize(new Dimension(175, 22));
//        Contact_Label.setPreferredSize(new Dimension(175, 22));
//        Email_Label.setPreferredSize(new Dimension(175, 22));
//        UserName_Label.setPreferredSize(new Dimension(175, 22));
        Password_Label.setPreferredSize(new Dimension(175, 22));
//        CNICValidity_Label.setPreferredSize(new Dimension(240, 9));
        contactValidity_Label.setPreferredSize(new Dimension(240, 9));
        NameValidity_Label.setPreferredSize(new Dimension(240, 9));
//        EmailValidity_Label.setPreferredSize(new Dimension(240, 9));
//        UserNameValidity_Label.setPreferredSize(new Dimension(240, 9));
        PasswordValidity_Label.setPreferredSize(new Dimension(240, 9));

//        CNICValidity_Label.setForeground(Color.red);
        contactValidity_Label.setForeground(Color.red);
        NameValidity_Label.setForeground(Color.red);
        AddressValidity_Label.setForeground(Color.red);
//        UserNameValidity_Label.setForeground(Color.red);
        PasswordValidity_Label.setForeground(Color.red);
//
        frame.add(Name_Label, new AbsoluteConstraints(10, 5));
        frame.add(Name_TextField, new AbsoluteConstraints(195, 5));
        frame.add(NameValidity_Label, new AbsoluteConstraints(195, 30));

        frame.add(Address_Label, new AbsoluteConstraints(10, 42));
        frame.add(Address_TextField, new AbsoluteConstraints(195, 42));
        frame.add(AddressValidity_Label, new AbsoluteConstraints(195, 66));

        frame.add(Contact_Label, new AbsoluteConstraints(10, 77));
        frame.add(Contact_TextField, new AbsoluteConstraints(195, 77));
        frame.add(contactValidity_Label, new AbsoluteConstraints(195, 102));
        
        

        frame.add(Add_Button, new AbsoluteConstraints(100, 225, 100, 22));
        frame.add(Cancel_Button, new AbsoluteConstraints(250, 225, 100, 22));

        Add_Button.addActionListener(new Customer_Add_ActionListener());

        Cancel_Button.addActionListener(new Customer_Add_ActionListener());
    }

    private class Customer_Add_ActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Add": {
//                    String cnic = CNIC_TextField.getText().trim();
                    String name = Name_TextField.getText().trim();
                    String contact = Contact_TextField.getText().trim();
                    String address = Address_TextField.getText().trim();


//                    if (Customer.isCNICValid(cnic)) {
//                        Customer customer = Customer.SearchByCNIC(cnic);
//                        if (customer == null) {
//                        if (customer == null) {
//                            if (Customer.isNameValid(name)) {
//                                if (Customer.isContactNoValid(contact)) {
                                    new Customer(0, 0, name, contact,address).Add(); // ID is Auto
                                    Parent_JFrame.getMainFrame().getContentPane().removeAll();
                                    Customer_Details cd = new Customer_Details();
                                    Parent_JFrame.getMainFrame().add(cd.getMainPanel());
                                    Parent_JFrame.getMainFrame().getContentPane().revalidate();
                                    Parent_JFrame.getMainFrame().setEnabled(true);
                                    JOptionPane.showMessageDialog(null, "Customer added successfully !");
                                    frame.dispose();
//                                } else {
//                                    JOptionPane.showMessageDialog(null, "Invalid contact no. !");
//                                }
//                            } else {
//                                JOptionPane.showMessageDialog(null, "Invalid Name !");
//                            }
//                        } else {
//                            JOptionPane.showMessageDialog(null, "This CNIC is already registered !");
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Invalid CNIC");
//                    }
                    break;
                }
                case "Cancel": {
                    Parent_JFrame.getMainFrame().setEnabled(true);
                    frame.dispose();
                    break;
                }
            }
        }

    }
}