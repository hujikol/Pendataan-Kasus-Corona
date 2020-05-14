package ResponsiPbo.model;

import ResponsiPbo.main.DataKorona;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TabelKoronaModel extends AbstractTableModel {

    private List<DataKorona> list = new ArrayList<DataKorona>();

    public void setList(List<DataKorona> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    public boolean add(DataKorona dataKorona) {
        try {
            return list.add(dataKorona);
        } finally {
            fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
        }
    }

    public DataKorona get(int index) {
        return list.get(index);
    }

    public DataKorona set(int index, DataKorona element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public DataKorona remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nama Daerah";
            case 2:
                return "ODP";
            case 3:
                return "PDP";
            case 4:
                return "Positif";
            case 5:
                return "Status";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getIdDaerah();
            case 1:
                return list.get(rowIndex).getNamaDaerah();
            case 2:
                return list.get(rowIndex).getOdp();
            case 3:
                return list.get(rowIndex).getPdp();
            case 4:
                return list.get(rowIndex).getPositif();
            case 5:
                return list.get(rowIndex).getStatus();
            default:
                return null;

        }
    }
}
