package NHF;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class KonyvData extends AbstractTableModel {

    List<Konyv> keres = new ArrayList<>();

    @Override
    public int getRowCount() {
        return keres.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Konyv book = keres.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return book.getCim();
            case 1:
                return book.getIro();
            case 2:
                return book.getMufaj();
            case 3:
                return book.getKiado();
            case 4:
                return book.getKategoria();
            case 5:
                return book.isKolcsonozve_van();
            case 6:
                return book.getKiadas_datum();
            case 7:
                return book.getVisszahozatal_datum();
            case 8:
                return book.getLeiras();
        }

        return null;
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Cím";
            case 1:
                return "Író";
            case 2:
                return "Műfaj";
            case 3:
                return "Kiadó";
            case 4:
                return "Kategória";
            case 5:
                return "Kölcsönözve van-e";
            case 6:
                return "Kiadás dátuma";
            case 7:
                return "Visszahozatal dátuma";
            case 8:
                return "Leírás";

        }
        return null;
    }

    public Class<?> getColumnClass(int columnIndex) {//3. feladat megvoltak adva ezek
        switch (columnIndex){
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return Boolean.class;
            case 6:
                return String.class;
            case 7:
                return String.class;
            case 8:
                return String.class;
            default:
                return String.class;
        }
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {//4.feladat
        if(keres.get(rowIndex).isKolcsonozve_van()){
            if(columnIndex == 6|| columnIndex == 7 ){
                return true;
            }
        }

         if( columnIndex == 0 || columnIndex == 1 || columnIndex == 5|| columnIndex == 8){
            return true;
        }else{
            return false;
        }

    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Konyv book = keres.get(rowIndex);
        if(columnIndex == 5){
            book.setKolcsonozve_van((Boolean) aValue);
        }else if(columnIndex == 1){
            book.setIro((String) aValue);
        }else if(columnIndex == 0){
            book.setCim((String) aValue);
        }
        else if(columnIndex == 8){
            book.setLeiras((String) aValue);
        }
        else if(columnIndex == 6){
            book.setKiadas_datum((String) aValue);
        }
        else if(columnIndex == 7){
            book.setVisszahozatal_datum((String) aValue);
        }
    }
}
