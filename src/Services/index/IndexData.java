package Services.index;

public class IndexData {
    private String tableName;
    private int nonUnique;
    private String keyName;
    private int seqInIndex;
    private String colunmName;

    public IndexData(String tableName, int nonUnique, String keyName, int seqInIndex, String colunmName) {
        this.tableName = tableName;
        this.nonUnique = nonUnique;
        this.keyName = keyName;
        this.seqInIndex = seqInIndex;
        this.colunmName = colunmName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getNonUnique() {
        return nonUnique;
    }

    public void setNonUnique(int nonUnique) {
        this.nonUnique = nonUnique;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public int getSeqInIndex() {
        return seqInIndex;
    }

    public void setSeqInIndex(int seqInIndex) {
        this.seqInIndex = seqInIndex;
    }

    public String getColunmName() {
        return colunmName;
    }

    public void setColunmName(String colunmName) {
        this.colunmName = colunmName;
    }
}
