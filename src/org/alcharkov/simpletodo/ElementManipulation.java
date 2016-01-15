/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alcharkov.simpletodo;

import java.util.Collection;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author Aleksandr Charkov <aleksandr.charkov at stat.gov.lt>
 */
public interface ElementManipulation {
    public void strikeElement(JList<String> jList, JTextField jTextField);
    public DefaultListModel<String> sortElements(DefaultListModel<String> model);
    public Collection<String> defaultListModel2List(DefaultListModel<String> model);
}
