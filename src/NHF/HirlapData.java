package NHF;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HirlapData extends AbstractTableModel {
    List<Hirlap> keres = new ArrayList<>();

    @Override
    public int getRowCount() {
        return keres.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Hirlap hirlap = keres.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return hirlap.getCim();
            case 1:
                return hirlap.getSzerkeszto();
            case 2:
                return hirlap.getNyelve();
            case 3:
                return hirlap.getTipus();
            case 4:
                return hirlap.isKolcsonozve_van();
            case 5:
                return hirlap.getKiadas_datum();
            case 6:
                return hirlap.getVisszahozatal_datum();
            case 7:
                return hirlap.getLeiras();
        }

        return null;
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Cím";
            case 1:
                return "Szerkesztő";
            case 2:
                return "Nyelve";
            case 3:
                return "Típusa";
            case 4:
                return "Kölcsönözve van-e";
            case 5:
                return "Kiadás dátuma";
            case 6:
                return "Visszahozatal dátuma";
            case 7:
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
                return Nyelv.class;
            case 3:
                return Tipus.class;
            case 4:
                return Boolean.class;
            case 5:
                return String.class;
            case 6:
                return String.class;
            case 7:
                return String.class;
            default:
                return String.class;
        }
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {//4.feladat
        if(keres.get(rowIndex).isKolcsonozve_van()){
            if( columnIndex == 5|| columnIndex == 6){
                return true;
            }
        }
        if( columnIndex == 0 || columnIndex == 1 || columnIndex == 4||columnIndex == 7){
            return true;
        }else{
            return false;
        }
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Hirlap hirlap = keres.get(rowIndex);
        if(columnIndex == 4){
            hirlap.setKolcsonozve_van((Boolean) aValue);
        }else if(columnIndex == 0){
            hirlap.setCim((String) aValue);
        }else if(columnIndex == 1){
            hirlap.setSzerkeszto((String) aValue);
        }else if(columnIndex == 5){
            hirlap.setKiadas_datum((String) aValue);
        }else if(columnIndex == 6){
            hirlap.setVisszahozatal_datum((String) aValue);
        }
        else if(columnIndex == 7){
            hirlap.setLeiras((String) aValue);
        }
    }
}
