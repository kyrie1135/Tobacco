package com.Lph.project.resultinput.input.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TCCClientsatisfysurveyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public TCCClientsatisfysurveyExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        public Criteria andBickidIsNull() {
            addCriterion("BICKID is null");
            return (Criteria) this;
        }

        public Criteria andBickidIsNotNull() {
            addCriterion("BICKID is not null");
            return (Criteria) this;
        }

        public Criteria andBickidEqualTo(String value) {
            addCriterion("BICKID =", value, "bickid");
            return (Criteria) this;
        }

        public Criteria andBickidNotEqualTo(String value) {
            addCriterion("BICKID <>", value, "bickid");
            return (Criteria) this;
        }

        public Criteria andBickidGreaterThan(String value) {
            addCriterion("BICKID >", value, "bickid");
            return (Criteria) this;
        }

        public Criteria andBickidGreaterThanOrEqualTo(String value) {
            addCriterion("BICKID >=", value, "bickid");
            return (Criteria) this;
        }

        public Criteria andBickidLessThan(String value) {
            addCriterion("BICKID <", value, "bickid");
            return (Criteria) this;
        }

        public Criteria andBickidLessThanOrEqualTo(String value) {
            addCriterion("BICKID <=", value, "bickid");
            return (Criteria) this;
        }

        public Criteria andBickidLike(String value) {
            addCriterion("BICKID like", value, "bickid");
            return (Criteria) this;
        }

        public Criteria andBickidNotLike(String value) {
            addCriterion("BICKID not like", value, "bickid");
            return (Criteria) this;
        }

        public Criteria andBickidIn(List<String> values) {
            addCriterion("BICKID in", values, "bickid");
            return (Criteria) this;
        }

        public Criteria andBickidNotIn(List<String> values) {
            addCriterion("BICKID not in", values, "bickid");
            return (Criteria) this;
        }

        public Criteria andBickidBetween(String value1, String value2) {
            addCriterion("BICKID between", value1, value2, "bickid");
            return (Criteria) this;
        }

        public Criteria andBickidNotBetween(String value1, String value2) {
            addCriterion("BICKID not between", value1, value2, "bickid");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNull() {
            addCriterion("DEPT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNotNull() {
            addCriterion("DEPT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDeptNameEqualTo(String value) {
            addCriterion("DEPT_NAME =", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotEqualTo(String value) {
            addCriterion("DEPT_NAME <>", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThan(String value) {
            addCriterion("DEPT_NAME >", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThanOrEqualTo(String value) {
            addCriterion("DEPT_NAME >=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThan(String value) {
            addCriterion("DEPT_NAME <", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThanOrEqualTo(String value) {
            addCriterion("DEPT_NAME <=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLike(String value) {
            addCriterion("DEPT_NAME like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotLike(String value) {
            addCriterion("DEPT_NAME not like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameIn(List<String> values) {
            addCriterion("DEPT_NAME in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotIn(List<String> values) {
            addCriterion("DEPT_NAME not in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameBetween(String value1, String value2) {
            addCriterion("DEPT_NAME between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotBetween(String value1, String value2) {
            addCriterion("DEPT_NAME not between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andClientCodeIsNull() {
            addCriterion("CLIENT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andClientCodeIsNotNull() {
            addCriterion("CLIENT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andClientCodeEqualTo(String value) {
            addCriterion("CLIENT_CODE =", value, "clientCode");
            return (Criteria) this;
        }

        public Criteria andClientCodeNotEqualTo(String value) {
            addCriterion("CLIENT_CODE <>", value, "clientCode");
            return (Criteria) this;
        }

        public Criteria andClientCodeGreaterThan(String value) {
            addCriterion("CLIENT_CODE >", value, "clientCode");
            return (Criteria) this;
        }

        public Criteria andClientCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CLIENT_CODE >=", value, "clientCode");
            return (Criteria) this;
        }

        public Criteria andClientCodeLessThan(String value) {
            addCriterion("CLIENT_CODE <", value, "clientCode");
            return (Criteria) this;
        }

        public Criteria andClientCodeLessThanOrEqualTo(String value) {
            addCriterion("CLIENT_CODE <=", value, "clientCode");
            return (Criteria) this;
        }

        public Criteria andClientCodeLike(String value) {
            addCriterion("CLIENT_CODE like", value, "clientCode");
            return (Criteria) this;
        }

        public Criteria andClientCodeNotLike(String value) {
            addCriterion("CLIENT_CODE not like", value, "clientCode");
            return (Criteria) this;
        }

        public Criteria andClientCodeIn(List<String> values) {
            addCriterion("CLIENT_CODE in", values, "clientCode");
            return (Criteria) this;
        }

        public Criteria andClientCodeNotIn(List<String> values) {
            addCriterion("CLIENT_CODE not in", values, "clientCode");
            return (Criteria) this;
        }

        public Criteria andClientCodeBetween(String value1, String value2) {
            addCriterion("CLIENT_CODE between", value1, value2, "clientCode");
            return (Criteria) this;
        }

        public Criteria andClientCodeNotBetween(String value1, String value2) {
            addCriterion("CLIENT_CODE not between", value1, value2, "clientCode");
            return (Criteria) this;
        }

        public Criteria andInputDateIsNull() {
            addCriterion("INPUT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andInputDateIsNotNull() {
            addCriterion("INPUT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andInputDateEqualTo(Date value) {
            addCriterionForJDBCDate("INPUT_DATE =", value, "inputDate");
            return (Criteria) this;
        }

        public Criteria andInputDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("INPUT_DATE <>", value, "inputDate");
            return (Criteria) this;
        }

        public Criteria andInputDateGreaterThan(Date value) {
            addCriterionForJDBCDate("INPUT_DATE >", value, "inputDate");
            return (Criteria) this;
        }

        public Criteria andInputDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("INPUT_DATE >=", value, "inputDate");
            return (Criteria) this;
        }

        public Criteria andInputDateLessThan(Date value) {
            addCriterionForJDBCDate("INPUT_DATE <", value, "inputDate");
            return (Criteria) this;
        }

        public Criteria andInputDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("INPUT_DATE <=", value, "inputDate");
            return (Criteria) this;
        }

        public Criteria andInputDateIn(List<Date> values) {
            addCriterionForJDBCDate("INPUT_DATE in", values, "inputDate");
            return (Criteria) this;
        }

        public Criteria andInputDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("INPUT_DATE not in", values, "inputDate");
            return (Criteria) this;
        }

        public Criteria andInputDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("INPUT_DATE between", value1, value2, "inputDate");
            return (Criteria) this;
        }

        public Criteria andInputDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("INPUT_DATE not between", value1, value2, "inputDate");
            return (Criteria) this;
        }

        public Criteria andGetDateIsNull() {
            addCriterion("GET_DATE is null");
            return (Criteria) this;
        }

        public Criteria andGetDateIsNotNull() {
            addCriterion("GET_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andGetDateEqualTo(Date value) {
            addCriterionForJDBCDate("GET_DATE =", value, "getDate");
            return (Criteria) this;
        }

        public Criteria andGetDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("GET_DATE <>", value, "getDate");
            return (Criteria) this;
        }

        public Criteria andGetDateGreaterThan(Date value) {
            addCriterionForJDBCDate("GET_DATE >", value, "getDate");
            return (Criteria) this;
        }

        public Criteria andGetDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("GET_DATE >=", value, "getDate");
            return (Criteria) this;
        }

        public Criteria andGetDateLessThan(Date value) {
            addCriterionForJDBCDate("GET_DATE <", value, "getDate");
            return (Criteria) this;
        }

        public Criteria andGetDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("GET_DATE <=", value, "getDate");
            return (Criteria) this;
        }

        public Criteria andGetDateIn(List<Date> values) {
            addCriterionForJDBCDate("GET_DATE in", values, "getDate");
            return (Criteria) this;
        }

        public Criteria andGetDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("GET_DATE not in", values, "getDate");
            return (Criteria) this;
        }

        public Criteria andGetDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("GET_DATE between", value1, value2, "getDate");
            return (Criteria) this;
        }

        public Criteria andGetDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("GET_DATE not between", value1, value2, "getDate");
            return (Criteria) this;
        }

        public Criteria andInputerIsNull() {
            addCriterion("INPUTER is null");
            return (Criteria) this;
        }

        public Criteria andInputerIsNotNull() {
            addCriterion("INPUTER is not null");
            return (Criteria) this;
        }

        public Criteria andInputerEqualTo(String value) {
            addCriterion("INPUTER =", value, "inputer");
            return (Criteria) this;
        }

        public Criteria andInputerNotEqualTo(String value) {
            addCriterion("INPUTER <>", value, "inputer");
            return (Criteria) this;
        }

        public Criteria andInputerGreaterThan(String value) {
            addCriterion("INPUTER >", value, "inputer");
            return (Criteria) this;
        }

        public Criteria andInputerGreaterThanOrEqualTo(String value) {
            addCriterion("INPUTER >=", value, "inputer");
            return (Criteria) this;
        }

        public Criteria andInputerLessThan(String value) {
            addCriterion("INPUTER <", value, "inputer");
            return (Criteria) this;
        }

        public Criteria andInputerLessThanOrEqualTo(String value) {
            addCriterion("INPUTER <=", value, "inputer");
            return (Criteria) this;
        }

        public Criteria andInputerLike(String value) {
            addCriterion("INPUTER like", value, "inputer");
            return (Criteria) this;
        }

        public Criteria andInputerNotLike(String value) {
            addCriterion("INPUTER not like", value, "inputer");
            return (Criteria) this;
        }

        public Criteria andInputerIn(List<String> values) {
            addCriterion("INPUTER in", values, "inputer");
            return (Criteria) this;
        }

        public Criteria andInputerNotIn(List<String> values) {
            addCriterion("INPUTER not in", values, "inputer");
            return (Criteria) this;
        }

        public Criteria andInputerBetween(String value1, String value2) {
            addCriterion("INPUTER between", value1, value2, "inputer");
            return (Criteria) this;
        }

        public Criteria andInputerNotBetween(String value1, String value2) {
            addCriterion("INPUTER not between", value1, value2, "inputer");
            return (Criteria) this;
        }

        public Criteria andGeterIsNull() {
            addCriterion("GETER is null");
            return (Criteria) this;
        }

        public Criteria andGeterIsNotNull() {
            addCriterion("GETER is not null");
            return (Criteria) this;
        }

        public Criteria andGeterEqualTo(String value) {
            addCriterion("GETER =", value, "geter");
            return (Criteria) this;
        }

        public Criteria andGeterNotEqualTo(String value) {
            addCriterion("GETER <>", value, "geter");
            return (Criteria) this;
        }

        public Criteria andGeterGreaterThan(String value) {
            addCriterion("GETER >", value, "geter");
            return (Criteria) this;
        }

        public Criteria andGeterGreaterThanOrEqualTo(String value) {
            addCriterion("GETER >=", value, "geter");
            return (Criteria) this;
        }

        public Criteria andGeterLessThan(String value) {
            addCriterion("GETER <", value, "geter");
            return (Criteria) this;
        }

        public Criteria andGeterLessThanOrEqualTo(String value) {
            addCriterion("GETER <=", value, "geter");
            return (Criteria) this;
        }

        public Criteria andGeterLike(String value) {
            addCriterion("GETER like", value, "geter");
            return (Criteria) this;
        }

        public Criteria andGeterNotLike(String value) {
            addCriterion("GETER not like", value, "geter");
            return (Criteria) this;
        }

        public Criteria andGeterIn(List<String> values) {
            addCriterion("GETER in", values, "geter");
            return (Criteria) this;
        }

        public Criteria andGeterNotIn(List<String> values) {
            addCriterion("GETER not in", values, "geter");
            return (Criteria) this;
        }

        public Criteria andGeterBetween(String value1, String value2) {
            addCriterion("GETER between", value1, value2, "geter");
            return (Criteria) this;
        }

        public Criteria andGeterNotBetween(String value1, String value2) {
            addCriterion("GETER not between", value1, value2, "geter");
            return (Criteria) this;
        }

        public Criteria andIsOverIsNull() {
            addCriterion("IS_OVER is null");
            return (Criteria) this;
        }

        public Criteria andIsOverIsNotNull() {
            addCriterion("IS_OVER is not null");
            return (Criteria) this;
        }

        public Criteria andIsOverEqualTo(Integer value) {
            addCriterion("IS_OVER =", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverNotEqualTo(Integer value) {
            addCriterion("IS_OVER <>", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverGreaterThan(Integer value) {
            addCriterion("IS_OVER >", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_OVER >=", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverLessThan(Integer value) {
            addCriterion("IS_OVER <", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverLessThanOrEqualTo(Integer value) {
            addCriterion("IS_OVER <=", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverIn(List<Integer> values) {
            addCriterion("IS_OVER in", values, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverNotIn(List<Integer> values) {
            addCriterion("IS_OVER not in", values, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverBetween(Integer value1, Integer value2) {
            addCriterion("IS_OVER between", value1, value2, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_OVER not between", value1, value2, "isOver");
            return (Criteria) this;
        }
    }

    /**
     */
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