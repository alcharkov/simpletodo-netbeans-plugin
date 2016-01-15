/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alcharkov.simpletodo;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author Aleksandr Charkov <aleksandr.charkov at stat.gov.lt>
 */
public class WindowActionsImpl implements WindowAction {

    @Override
    public void addElement(JList<String> jList, JTextField jTextField) {
        DefaultListModel<String> model = (DefaultListModel<String>) jList.getModel();
        ElementManipulation elementManipulation = new ElementManipulationImpl();
        String jText = jTextField.getText();
        if (!jText.isEmpty()) {           
            model.addElement(jTextField.getText());
            jTextField.setText("");
            jList.setModel(elementManipulation.sortElements(model));
        }
    }

    

    @Override
    public void removeAllElements(JList<String> jList) {
        if (jList.getModel() != null) {
            jList.setModel(new DefaultListModel<String>());
        }
    }

}
