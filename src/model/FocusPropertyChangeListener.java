package model;

//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//
//
//public class FocusPropertyChangeListener<String> implements ChangeListener<String> {
//
//    @Override
//    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//        if (TA_keyWord)
//        if (!oldValue.equals(newValue)) {
//            System.out.print(observable);
//        }
//    }
//}







/*public class InterfaceModelProperty {
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
}*/































// todo : a garder memo
//IImageMetadata metadata = null;
//        String name;
//
//        try {
//        metadata = Imaging.getMetadata(new File(filename));
//        } catch (ImageReadException | IOException e) {
//        }
//
//        if (metadata instanceof JpegImageMetadata) {
//final JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadata;
//final List<IImageMetadataItem> items = jpegMetadata.getItems();
//
//        for (int i = 0; i < items.size(); i++) {
//final IImageMetadataItem item = items.get(i);
//        name = item.toString().substring(0, item.toString().indexOf(":"));
//        switch (name) {
//        case "Object Name" :
//        case "ImageDescription" :
//        case "Keywords" :
//        System.out.println(item.toString());
//        break;
//        }
//        }
//        }