/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alcharkov.simpletodo;

import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author Aleksandr Charkov <aleksandr.charkov at stat.gov.lt>
 */
public interface WindowAction {
    public void addElement(JList<String> jList, JTextField jTextField);
    public void removeAllElements(JList<String> jList);
}
