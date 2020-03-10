package com.Lph.project.samplebright.bright.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TCCSampleBrightExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public TCCSampleBrightExample() {
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

        public Criteria andClientNameIsNull() {
            addCriterion("CLIENT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andClientNameIsNotNull() {
            addCriterion("CLIENT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andClientNameEqualTo(String value) {
            addCriterion("CLIENT_NAME =", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotEqualTo(String value) {
            addCriterion("CLIENT_NAME <>", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameGreaterThan(String value) {
            addCriterion("CLIENT_NAME >", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameGreaterThanOrEqualTo(String value) {
            addCriterion("CLIENT_NAME >=", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLessThan(String value) {
            addCriterion("CLIENT_NAME <", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLessThanOrEqualTo(String value) {
            addCriterion("CLIENT_NAME <=", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLike(String value) {
            addCriterion("CLIENT_NAME like", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotLike(String value) {
            addCriterion("CLIENT_NAME not like", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameIn(List<String> values) {
            addCriterion("CLIENT_NAME in", values, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotIn(List<String> values) {
            addCriterion("CLIENT_NAME not in", values, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameBetween(String value1, String value2) {
            addCriterion("CLIENT_NAME between", value1, value2, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotBetween(String value1, String value2) {
            addCriterion("CLIENT_NAME not between", value1, value2, "clientName");
            return (Criteria) this;
        }

        public Criteria andSampleDataIsNull() {
            addCriterion("SAMPLE_DATA is null");
            return (Criteria) this;
        }

        public Criteria andSampleDataIsNotNull() {
            addCriterion("SAMPLE_DATA is not null");
            return (Criteria) this;
        }

        public Criteria andSampleDataEqualTo(Date value) {
            addCriterionForJDBCDate("SAMPLE_DATA =", value, "sampleData");
            return (Criteria) this;
        }

        public Criteria andSampleDataNotEqualTo(Date value) {
            addCriterionForJDBCDate("SAMPLE_DATA <>", value, "sampleData");
            return (Criteria) this;
        }

        public Criteria andSampleDataGreaterThan(Date value) {
            addCriterionForJDBCDate("SAMPLE_DATA >", value, "sampleData");
            return (Criteria) this;
        }

        public Criteria andSampleDataGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SAMPLE_DATA >=", value, "sampleData");
            return (Criteria) this;
        }

        public Criteria andSampleDataLessThan(Date value) {
            addCriterionForJDBCDate("SAMPLE_DATA <", value, "sampleData");
            return (Criteria) this;
        }

        public Criteria andSampleDataLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SAMPLE_DATA <=", value, "sampleData");
            return (Criteria) this;
        }

        public Criteria andSampleDataIn(List<Date> values) {
            addCriterionForJDBCDate("SAMPLE_DATA in", values, "sampleData");
            return (Criteria) this;
        }

        public Criteria andSampleDataNotIn(List<Date> values) {
            addCriterionForJDBCDate("SAMPLE_DATA not in", values, "sampleData");
            return (Criteria) this;
        }

        public Criteria andSampleDataBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SAMPLE_DATA between", value1, value2, "sampleData");
            return (Criteria) this;
        }

        public Criteria andSampleDataNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SAMPLE_DATA not between", value1, value2, "sampleData");
            return (Criteria) this;
        }

        public Criteria andDiaochaDataIsNull() {
            addCriterion("DIAOCHA_DATA is null");
            return (Criteria) this;
        }

        public Criteria andDiaochaDataIsNotNull() {
            addCriterion("DIAOCHA_DATA is not null");
            return (Criteria) this;
        }

        public Criteria andDiaochaDataEqualTo(Date value) {
            addCriterionForJDBCDate("DIAOCHA_DATA =", value, "diaochaData");
            return (Criteria) this;
        }

        public Criteria andDiaochaDataNotEqualTo(Date value) {
            addCriterionForJDBCDate("DIAOCHA_DATA <>", value, "diaochaData");
            return (Criteria) this;
        }

        public Criteria andDiaochaDataGreaterThan(Date value) {
            addCriterionForJDBCDate("DIAOCHA_DATA >", value, "diaochaData");
            return (Criteria) this;
        }

        public Criteria andDiaochaDataGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DIAOCHA_DATA >=", value, "diaochaData");
            return (Criteria) this;
        }

        public Criteria andDiaochaDataLessThan(Date value) {
            addCriterionForJDBCDate("DIAOCHA_DATA <", value, "diaochaData");
            return (Criteria) this;
        }

        public Criteria andDiaochaDataLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DIAOCHA_DATA <=", value, "diaochaData");
            return (Criteria) this;
        }

        public Criteria andDiaochaDataIn(List<Date> values) {
            addCriterionForJDBCDate("DIAOCHA_DATA in", values, "diaochaData");
            return (Criteria) this;
        }

        public Criteria andDiaochaDataNotIn(List<Date> values) {
            addCriterionForJDBCDate("DIAOCHA_DATA not in", values, "diaochaData");
            return (Criteria) this;
        }

        public Criteria andDiaochaDataBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DIAOCHA_DATA between", value1, value2, "diaochaData");
            return (Criteria) this;
        }

        public Criteria andDiaochaDataNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DIAOCHA_DATA not between", value1, value2, "diaochaData");
            return (Criteria) this;
        }

        public Criteria andLuruDataIsNull() {
            addCriterion("LURU_DATA is null");
            return (Criteria) this;
        }

        public Criteria andLuruDataIsNotNull() {
            addCriterion("LURU_DATA is not null");
            return (Criteria) this;
        }

        public Criteria andLuruDataEqualTo(Date value) {
            addCriterionForJDBCDate("LURU_DATA =", value, "luruData");
            return (Criteria) this;
        }

        public Criteria andLuruDataNotEqualTo(Date value) {
            addCriterionForJDBCDate("LURU_DATA <>", value, "luruData");
            return (Criteria) this;
        }

        public Criteria andLuruDataGreaterThan(Date value) {
            addCriterionForJDBCDate("LURU_DATA >", value, "luruData");
            return (Criteria) this;
        }

        public Criteria andLuruDataGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LURU_DATA >=", value, "luruData");
            return (Criteria) this;
        }

        public Criteria andLuruDataLessThan(Date value) {
            addCriterionForJDBCDate("LURU_DATA <", value, "luruData");
            return (Criteria) this;
        }

        public Criteria andLuruDataLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LURU_DATA <=", value, "luruData");
            return (Criteria) this;
        }

        public Criteria andLuruDataIn(List<Date> values) {
            addCriterionForJDBCDate("LURU_DATA in", values, "luruData");
            return (Criteria) this;
        }

        public Criteria andLuruDataNotIn(List<Date> values) {
            addCriterionForJDBCDate("LURU_DATA not in", values, "luruData");
            return (Criteria) this;
        }

        public Criteria andLuruDataBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LURU_DATA between", value1, value2, "luruData");
            return (Criteria) this;
        }

        public Criteria andLuruDataNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LURU_DATA not between", value1, value2, "luruData");
            return (Criteria) this;
        }

        public Criteria andLuruPerIsNull() {
            addCriterion("LURU_PER is null");
            return (Criteria) this;
        }

        public Criteria andLuruPerIsNotNull() {
            addCriterion("LURU_PER is not null");
            return (Criteria) this;
        }

        public Criteria andLuruPerEqualTo(String value) {
            addCriterion("LURU_PER =", value, "luruPer");
            return (Criteria) this;
        }

        public Criteria andLuruPerNotEqualTo(String value) {
            addCriterion("LURU_PER <>", value, "luruPer");
            return (Criteria) this;
        }

        public Criteria andLuruPerGreaterThan(String value) {
            addCriterion("LURU_PER >", value, "luruPer");
            return (Criteria) this;
        }

        public Criteria andLuruPerGreaterThanOrEqualTo(String value) {
            addCriterion("LURU_PER >=", value, "luruPer");
            return (Criteria) this;
        }

        public Criteria andLuruPerLessThan(String value) {
            addCriterion("LURU_PER <", value, "luruPer");
            return (Criteria) this;
        }

        public Criteria andLuruPerLessThanOrEqualTo(String value) {
            addCriterion("LURU_PER <=", value, "luruPer");
            return (Criteria) this;
        }

        public Criteria andLuruPerLike(String value) {
            addCriterion("LURU_PER like", value, "luruPer");
            return (Criteria) this;
        }

        public Criteria andLuruPerNotLike(String value) {
            addCriterion("LURU_PER not like", value, "luruPer");
            return (Criteria) this;
        }

        public Criteria andLuruPerIn(List<String> values) {
            addCriterion("LURU_PER in", values, "luruPer");
            return (Criteria) this;
        }

        public Criteria andLuruPerNotIn(List<String> values) {
            addCriterion("LURU_PER not in", values, "luruPer");
            return (Criteria) this;
        }

        public Criteria andLuruPerBetween(String value1, String value2) {
            addCriterion("LURU_PER between", value1, value2, "luruPer");
            return (Criteria) this;
        }

        public Criteria andLuruPerNotBetween(String value1, String value2) {
            addCriterion("LURU_PER not between", value1, value2, "luruPer");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("DELETED is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("DELETED is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Integer value) {
            addCriterion("DELETED =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Integer value) {
            addCriterion("DELETED <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Integer value) {
            addCriterion("DELETED >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("DELETED >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Integer value) {
            addCriterion("DELETED <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("DELETED <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Integer> values) {
            addCriterion("DELETED in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Integer> values) {
            addCriterion("DELETED not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Integer value1, Integer value2) {
            addCriterion("DELETED between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("DELETED not between", value1, value2, "deleted");
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