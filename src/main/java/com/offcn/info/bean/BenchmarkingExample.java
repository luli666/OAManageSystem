package com.offcn.info.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BenchmarkingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BenchmarkingExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andComnameIsNull() {
            addCriterion("comname is null");
            return (Criteria) this;
        }

        public Criteria andComnameIsNotNull() {
            addCriterion("comname is not null");
            return (Criteria) this;
        }

        public Criteria andComnameEqualTo(String value) {
            addCriterion("comname =", value, "comname");
            return (Criteria) this;
        }

        public Criteria andComnameNotEqualTo(String value) {
            addCriterion("comname <>", value, "comname");
            return (Criteria) this;
        }

        public Criteria andComnameGreaterThan(String value) {
            addCriterion("comname >", value, "comname");
            return (Criteria) this;
        }

        public Criteria andComnameGreaterThanOrEqualTo(String value) {
            addCriterion("comname >=", value, "comname");
            return (Criteria) this;
        }

        public Criteria andComnameLessThan(String value) {
            addCriterion("comname <", value, "comname");
            return (Criteria) this;
        }

        public Criteria andComnameLessThanOrEqualTo(String value) {
            addCriterion("comname <=", value, "comname");
            return (Criteria) this;
        }

        public Criteria andComnameLike(String value) {
            addCriterion("comname like", value, "comname");
            return (Criteria) this;
        }

        public Criteria andComnameNotLike(String value) {
            addCriterion("comname not like", value, "comname");
            return (Criteria) this;
        }

        public Criteria andComnameIn(List<String> values) {
            addCriterion("comname in", values, "comname");
            return (Criteria) this;
        }

        public Criteria andComnameNotIn(List<String> values) {
            addCriterion("comname not in", values, "comname");
            return (Criteria) this;
        }

        public Criteria andComnameBetween(String value1, String value2) {
            addCriterion("comname between", value1, value2, "comname");
            return (Criteria) this;
        }

        public Criteria andComnameNotBetween(String value1, String value2) {
            addCriterion("comname not between", value1, value2, "comname");
            return (Criteria) this;
        }

        public Criteria andSalesAnountIsNull() {
            addCriterion("sales_anount is null");
            return (Criteria) this;
        }

        public Criteria andSalesAnountIsNotNull() {
            addCriterion("sales_anount is not null");
            return (Criteria) this;
        }

        public Criteria andSalesAnountEqualTo(Double value) {
            addCriterion("sales_anount =", value, "salesAnount");
            return (Criteria) this;
        }

        public Criteria andSalesAnountNotEqualTo(Double value) {
            addCriterion("sales_anount <>", value, "salesAnount");
            return (Criteria) this;
        }

        public Criteria andSalesAnountGreaterThan(Double value) {
            addCriterion("sales_anount >", value, "salesAnount");
            return (Criteria) this;
        }

        public Criteria andSalesAnountGreaterThanOrEqualTo(Double value) {
            addCriterion("sales_anount >=", value, "salesAnount");
            return (Criteria) this;
        }

        public Criteria andSalesAnountLessThan(Double value) {
            addCriterion("sales_anount <", value, "salesAnount");
            return (Criteria) this;
        }

        public Criteria andSalesAnountLessThanOrEqualTo(Double value) {
            addCriterion("sales_anount <=", value, "salesAnount");
            return (Criteria) this;
        }

        public Criteria andSalesAnountIn(List<Double> values) {
            addCriterion("sales_anount in", values, "salesAnount");
            return (Criteria) this;
        }

        public Criteria andSalesAnountNotIn(List<Double> values) {
            addCriterion("sales_anount not in", values, "salesAnount");
            return (Criteria) this;
        }

        public Criteria andSalesAnountBetween(Double value1, Double value2) {
            addCriterion("sales_anount between", value1, value2, "salesAnount");
            return (Criteria) this;
        }

        public Criteria andSalesAnountNotBetween(Double value1, Double value2) {
            addCriterion("sales_anount not between", value1, value2, "salesAnount");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andBusinessIsNull() {
            addCriterion("business is null");
            return (Criteria) this;
        }

        public Criteria andBusinessIsNotNull() {
            addCriterion("business is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessEqualTo(String value) {
            addCriterion("business =", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotEqualTo(String value) {
            addCriterion("business <>", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessGreaterThan(String value) {
            addCriterion("business >", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessGreaterThanOrEqualTo(String value) {
            addCriterion("business >=", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessLessThan(String value) {
            addCriterion("business <", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessLessThanOrEqualTo(String value) {
            addCriterion("business <=", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessLike(String value) {
            addCriterion("business like", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotLike(String value) {
            addCriterion("business not like", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessIn(List<String> values) {
            addCriterion("business in", values, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotIn(List<String> values) {
            addCriterion("business not in", values, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessBetween(String value1, String value2) {
            addCriterion("business between", value1, value2, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotBetween(String value1, String value2) {
            addCriterion("business not between", value1, value2, "business");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(String value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(String value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(String value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(String value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(String value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(String value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLike(String value) {
            addCriterion("priority like", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotLike(String value) {
            addCriterion("priority not like", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<String> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<String> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(String value1, String value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(String value1, String value2) {
            addCriterion("priority not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andDisadvantageIsNull() {
            addCriterion("disadvantage is null");
            return (Criteria) this;
        }

        public Criteria andDisadvantageIsNotNull() {
            addCriterion("disadvantage is not null");
            return (Criteria) this;
        }

        public Criteria andDisadvantageEqualTo(String value) {
            addCriterion("disadvantage =", value, "disadvantage");
            return (Criteria) this;
        }

        public Criteria andDisadvantageNotEqualTo(String value) {
            addCriterion("disadvantage <>", value, "disadvantage");
            return (Criteria) this;
        }

        public Criteria andDisadvantageGreaterThan(String value) {
            addCriterion("disadvantage >", value, "disadvantage");
            return (Criteria) this;
        }

        public Criteria andDisadvantageGreaterThanOrEqualTo(String value) {
            addCriterion("disadvantage >=", value, "disadvantage");
            return (Criteria) this;
        }

        public Criteria andDisadvantageLessThan(String value) {
            addCriterion("disadvantage <", value, "disadvantage");
            return (Criteria) this;
        }

        public Criteria andDisadvantageLessThanOrEqualTo(String value) {
            addCriterion("disadvantage <=", value, "disadvantage");
            return (Criteria) this;
        }

        public Criteria andDisadvantageLike(String value) {
            addCriterion("disadvantage like", value, "disadvantage");
            return (Criteria) this;
        }

        public Criteria andDisadvantageNotLike(String value) {
            addCriterion("disadvantage not like", value, "disadvantage");
            return (Criteria) this;
        }

        public Criteria andDisadvantageIn(List<String> values) {
            addCriterion("disadvantage in", values, "disadvantage");
            return (Criteria) this;
        }

        public Criteria andDisadvantageNotIn(List<String> values) {
            addCriterion("disadvantage not in", values, "disadvantage");
            return (Criteria) this;
        }

        public Criteria andDisadvantageBetween(String value1, String value2) {
            addCriterion("disadvantage between", value1, value2, "disadvantage");
            return (Criteria) this;
        }

        public Criteria andDisadvantageNotBetween(String value1, String value2) {
            addCriterion("disadvantage not between", value1, value2, "disadvantage");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andEmpCountIsNull() {
            addCriterion("emp_count is null");
            return (Criteria) this;
        }

        public Criteria andEmpCountIsNotNull() {
            addCriterion("emp_count is not null");
            return (Criteria) this;
        }

        public Criteria andEmpCountEqualTo(Integer value) {
            addCriterion("emp_count =", value, "empCount");
            return (Criteria) this;
        }

        public Criteria andEmpCountNotEqualTo(Integer value) {
            addCriterion("emp_count <>", value, "empCount");
            return (Criteria) this;
        }

        public Criteria andEmpCountGreaterThan(Integer value) {
            addCriterion("emp_count >", value, "empCount");
            return (Criteria) this;
        }

        public Criteria andEmpCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_count >=", value, "empCount");
            return (Criteria) this;
        }

        public Criteria andEmpCountLessThan(Integer value) {
            addCriterion("emp_count <", value, "empCount");
            return (Criteria) this;
        }

        public Criteria andEmpCountLessThanOrEqualTo(Integer value) {
            addCriterion("emp_count <=", value, "empCount");
            return (Criteria) this;
        }

        public Criteria andEmpCountIn(List<Integer> values) {
            addCriterion("emp_count in", values, "empCount");
            return (Criteria) this;
        }

        public Criteria andEmpCountNotIn(List<Integer> values) {
            addCriterion("emp_count not in", values, "empCount");
            return (Criteria) this;
        }

        public Criteria andEmpCountBetween(Integer value1, Integer value2) {
            addCriterion("emp_count between", value1, value2, "empCount");
            return (Criteria) this;
        }

        public Criteria andEmpCountNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_count not between", value1, value2, "empCount");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterionForJDBCDate("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}