/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alcharkov.simpletodo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author Aleksandr Charkov <aleksandr.charkov at stat.gov.lt>
 */
public class ElementManipulationImpl implements ElementManipulation {

    private static final String HTML_START = "<html><font color=\"gray\"><strike><i>";
    private static final String HTML_END = "</i></strike></font></html>";

    @Override
    public void strikeElement(JList<String> jList, JTextField jTextField) {
        int index = jList.getSelectedIndex();
        if (index != -1) {
            DefaultListModel<String> model = (DefaultListModel<String>) jList.getModel();
            String element = model.get(index);
            if (element != null) {
                model.set(index, decorateElementWithHtml(element));
            }
        }
    }

    @Override
    public DefaultListModel<String> sortElements(DefaultListModel<String> model) {
        if (model.getSize() > 1) {
            Collection<String> list = defaultListModel2List(model);         
            sortElementList((List<String>) list);
            model.clear();
            for (String element : list) {
                model.addElement(element);
            }
        }
        return model;
    }
        
    @Override
    public Collection<String> defaultListModel2List(DefaultListModel<String> model) {
            Collection<String> list = Collections.list(model.elements());
            Collections.sort((List<String>) list, String.CASE_INSENSITIVE_ORDER);
            return list;
    }
    
    public void sortElementList(List<String> list) {
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
    }

    private String decorateElementWithHtml(String element) {
        if (element.startsWith(HTML_START) && element.endsWith(HTML_END)) {
            return element.substring(HTML_START.length(), element.length() - HTML_END.length());
        }

        return HTML_START + element + HTML_END;
    }

}
