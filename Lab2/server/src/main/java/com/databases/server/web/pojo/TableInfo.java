package com.databases.server.web.pojo;

import java.util.List;
import java.util.Objects;

public class TableInfo<T>{
    private String name;
    private List<String> columns;
    private List<T> lines;
    private List<TableParam> params;

    public TableInfo(String name, List<String> columns, List<T> lines) {
        this.name = name;
        this.columns = columns;
        this.lines = lines;
    }

    public TableInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public List<T> getLines() {
        return lines;
    }

    public void setLines(List<T> lines) {
        this.lines = lines;
    }

  public List<TableParam> getParams() {
    return params;
  }

  public void setParams(List<TableParam> params) {
    this.params = params;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TableInfo<?> tableInfo = (TableInfo<?>) o;
    return Objects.equals(name, tableInfo.name) && Objects.equals(columns, tableInfo.columns) && Objects.equals(lines, tableInfo.lines) && Objects.equals(params, tableInfo.params);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, columns, lines, params);
  }
}
