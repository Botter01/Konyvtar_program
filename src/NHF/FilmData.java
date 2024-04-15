package NHF;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilmData extends AbstractTableModel {
    List<Filmografia> keres = new ArrayList<>();

    @Override
    public int getRowCount() {
        return keres.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Filmografia filmografia = keres.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return filmografia.getCim();
            case 1:
                return filmografia.getRendezo();
            case 2:
                return filmografia.getHordozo();
            case 3:
                return filmografia.isKolcsonozve_van();
            case 4:
                return filmografia.getKiadas_datum();
            case 5:
                return filmografia.getVisszahozatal_datum();
            case 6:
                return filmografia.getLeiras();
        }

        return null;
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Cím";
            case 1:
                return "Rendező";
            case 2:
                return "Hordozó";
            case 3:
                return "Kölcsönözve van-e";
            case 4:
                return "Kiadás dátuma";
            case 5:
                return "Visszahozatal dátuma";
            case 6:
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
                return Hordozo.class;
            case 3:
                return Boolean.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
            case 6:
                return String.class;
            default:
                return String.class;
        }
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(keres.get(rowIndex).isKolcsonozve_van()){
            if( columnIndex == 4|| columnIndex == 5){
                return true;
            }
        }
         if( columnIndex == 0 || columnIndex == 1 || columnIndex == 3 || columnIndex == 6){
            return true;
        }else{
            return false;
        }

    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Filmografia filmografia = keres.get(rowIndex);
        if(columnIndex == 3){
            filmografia.setKolcsonozve_van((Boolean) aValue);
        }else if(columnIndex == 0){
            filmografia.setCim((String) aValue);
        }else if(columnIndex == 1){
            filmografia.setRendezo((String) aValue);
        }else if(columnIndex == 4){
            filmografia.setKiadas_datum((String) aValue);
        }else if(columnIndex == 5){
            filmografia.setVisszahozatal_datum((String) aValue);
        }
        else if(columnIndex == 6){
            filmografia.setLeiras((String) aValue);
        }
    }
}
