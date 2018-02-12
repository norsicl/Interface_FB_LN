package model;

import javafx.beans.property.SimpleStringProperty;

public class InterfaceModelProperty {
    private final SimpleStringProperty m_val ;

    public InterfaceModelProperty() {
        m_val = new SimpleStringProperty () ;

    }
    public SimpleStringProperty valProperty () {
        return m_val ;
    }
    public void incValue () {
        m_val . set ( m_val . get () +1) ;
    }
}
