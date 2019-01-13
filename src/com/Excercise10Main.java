package com;

import com.Exercise10.Annotations.Column;
import com.Exercise10.Annotations.Table;
import com.Exercise10.Classes.QueryBuilder;
import com.Exercise10.Classes.TBL;

import java.lang.reflect.Field;

public class Excercise10Main {
    public static void main(String[] args) {
        TBL tbl = new TBL(33, "SeyyedAli", "Azimi", "0073675830");
        try {
            System.out.println((showInsertSql(tbl)));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static String showInsertSql(TBL tbl) throws IllegalAccessException {
        QueryBuilder table_query = new QueryBuilder("Create Table ");
        QueryBuilder insert_query = new QueryBuilder("Insert into ");
        QueryBuilder insert_query_end = new QueryBuilder(" Values ( ");
        if (tbl.getClass().isAnnotationPresent(Table.class)) {
            Table table = tbl.getClass().getAnnotationsByType(Table.class)[0];
            table_query.append(table.tb_name() + "(");
            insert_query.append(table.tb_name() + "(");
            Field[] fields = tbl.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true);
                if (field.isAnnotationPresent(Column.class)) {
                    Column[] column = field.getAnnotationsByType(Column.class);
                    String column_name = column[0].cl_name();
                    table_query.append(column_name);
                    String field_type = field.getType().toString();
                    if (i != fields.length - 1) {
                        insert_query.append(column_name + ",");
                        String command2 = "tbl.get" + field.getName() + "()";
                        switch (command2) {
                            case "tbl.getage()": {
                                insert_query_end.append((tbl.getAge() + ","));
                                break;
                            }
                            case "tbl.getname()": {
                                insert_query_end.append((tbl.getName() + ","));
                                break;
                            }
                            case "tbl.getfamilyName()": {
                                insert_query_end.append((tbl.getFamilyName() + ","));
                                break;
                            }
                            case "tbl.getSSN()": {
                                insert_query_end.append((tbl.getSSN() + ","));
                                break;
                            }
                        }
                        if (field_type.equalsIgnoreCase("class java.lang.String"))
                            table_query.append(" Varchar(100)" + ",");
                        else table_query.append(field_type + ",");
                    } else {
                        insert_query.append(column_name);
                        String command = "tbl.get" + field.getName() + "()";
                        switch (command) {
                            case "tbl.getage()": {
                                insert_query_end.append((tbl.getAge() + ""));
                                break;
                            }
                            case "tbl.getname()": {
                                insert_query_end.append((tbl.getName()));
                                break;
                            }
                            case "tbl.getfamilyName()": {
                                insert_query_end.append((tbl.getFamilyName()));
                                break;
                            }
                            case "tbl.getSSN()": {
                                insert_query_end.append((tbl.getSSN()));
                                break;
                            }
                        }
                        if (field_type.equalsIgnoreCase("class java.lang.String"))
                            table_query.append(" Varchar(100)");
                        else table_query.append(field_type);
                    }
                }
            }
            table_query.append(");");
            insert_query.append(")");
            insert_query_end.append(");");
            insert_query.append(insert_query_end);
        }
        System.out.println(insert_query.toString());
        return table_query.toString();
    }
}
