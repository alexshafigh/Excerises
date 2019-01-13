package com.Exercise10.Classes;

public class QueryBuilder {
    //    static QueryBuilder query;
    StringBuffer query;

    public QueryBuilder(String s) {

        query = new StringBuffer(s);
    }

    public QueryBuilder append(String string) {
        query.append(string + " ");
        return this;
    }


    @Override
    public String toString() {
        return query.toString();
    }

    public QueryBuilder append(QueryBuilder queryBuilder) {
        this.append(queryBuilder.toString());
        return this;
    }


}
