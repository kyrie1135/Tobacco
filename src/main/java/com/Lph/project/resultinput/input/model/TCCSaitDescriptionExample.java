package com.Lph.project.resultinput.input.model;

import java.util.ArrayList;
import java.util.List;

public class TCCSaitDescriptionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public TCCSaitDescriptionExample() {
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

        public Criteria andSatisfysurveytargetBickidIsNull() {
            addCriterion("SATISFYSURVEYTARGET_BICKID is null");
            return (Criteria) this;
        }

        public Criteria andSatisfysurveytargetBickidIsNotNull() {
            addCriterion("SATISFYSURVEYTARGET_BICKID is not null");
            return (Criteria) this;
        }

        public Criteria andSatisfysurveytargetBickidEqualTo(String value) {
            addCriterion("SATISFYSURVEYTARGET_BICKID =", value, "satisfysurveytargetBickid");
            return (Criteria) this;
        }

        public Criteria andSatisfysurveytargetBickidNotEqualTo(String value) {
            addCriterion("SATISFYSURVEYTARGET_BICKID <>", value, "satisfysurveytargetBickid");
            return (Criteria) this;
        }

        public Criteria andSatisfysurveytargetBickidGreaterThan(String value) {
            addCriterion("SATISFYSURVEYTARGET_BICKID >", value, "satisfysurveytargetBickid");
            return (Criteria) this;
        }

        public Criteria andSatisfysurveytargetBickidGreaterThanOrEqualTo(String value) {
            addCriterion("SATISFYSURVEYTARGET_BICKID >=", value, "satisfysurveytargetBickid");
            return (Criteria) this;
        }

        public Criteria andSatisfysurveytargetBickidLessThan(String value) {
            addCriterion("SATISFYSURVEYTARGET_BICKID <", value, "satisfysurveytargetBickid");
            return (Criteria) this;
        }

        public Criteria andSatisfysurveytargetBickidLessThanOrEqualTo(String value) {
            addCriterion("SATISFYSURVEYTARGET_BICKID <=", value, "satisfysurveytargetBickid");
            return (Criteria) this;
        }

        public Criteria andSatisfysurveytargetBickidLike(String value) {
            addCriterion("SATISFYSURVEYTARGET_BICKID like", value, "satisfysurveytargetBickid");
            return (Criteria) this;
        }

        public Criteria andSatisfysurveytargetBickidNotLike(String value) {
            addCriterion("SATISFYSURVEYTARGET_BICKID not like", value, "satisfysurveytargetBickid");
            return (Criteria) this;
        }

        public Criteria andSatisfysurveytargetBickidIn(List<String> values) {
            addCriterion("SATISFYSURVEYTARGET_BICKID in", values, "satisfysurveytargetBickid");
            return (Criteria) this;
        }

        public Criteria andSatisfysurveytargetBickidNotIn(List<String> values) {
            addCriterion("SATISFYSURVEYTARGET_BICKID not in", values, "satisfysurveytargetBickid");
            return (Criteria) this;
        }

        public Criteria andSatisfysurveytargetBickidBetween(String value1, String value2) {
            addCriterion("SATISFYSURVEYTARGET_BICKID between", value1, value2, "satisfysurveytargetBickid");
            return (Criteria) this;
        }

        public Criteria andSatisfysurveytargetBickidNotBetween(String value1, String value2) {
            addCriterion("SATISFYSURVEYTARGET_BICKID not between", value1, value2, "satisfysurveytargetBickid");
            return (Criteria) this;
        }

        public Criteria andSubscriptBickidIsNull() {
            addCriterion("SUBSCRIPT_BICKID is null");
            return (Criteria) this;
        }

        public Criteria andSubscriptBickidIsNotNull() {
            addCriterion("SUBSCRIPT_BICKID is not null");
            return (Criteria) this;
        }

        public Criteria andSubscriptBickidEqualTo(String value) {
            addCriterion("SUBSCRIPT_BICKID =", value, "subscriptBickid");
            return (Criteria) this;
        }

        public Criteria andSubscriptBickidNotEqualTo(String value) {
            addCriterion("SUBSCRIPT_BICKID <>", value, "subscriptBickid");
            return (Criteria) this;
        }

        public Criteria andSubscriptBickidGreaterThan(String value) {
            addCriterion("SUBSCRIPT_BICKID >", value, "subscriptBickid");
            return (Criteria) this;
        }

        public Criteria andSubscriptBickidGreaterThanOrEqualTo(String value) {
            addCriterion("SUBSCRIPT_BICKID >=", value, "subscriptBickid");
            return (Criteria) this;
        }

        public Criteria andSubscriptBickidLessThan(String value) {
            addCriterion("SUBSCRIPT_BICKID <", value, "subscriptBickid");
            return (Criteria) this;
        }

        public Criteria andSubscriptBickidLessThanOrEqualTo(String value) {
            addCriterion("SUBSCRIPT_BICKID <=", value, "subscriptBickid");
            return (Criteria) this;
        }

        public Criteria andSubscriptBickidLike(String value) {
            addCriterion("SUBSCRIPT_BICKID like", value, "subscriptBickid");
            return (Criteria) this;
        }

        public Criteria andSubscriptBickidNotLike(String value) {
            addCriterion("SUBSCRIPT_BICKID not like", value, "subscriptBickid");
            return (Criteria) this;
        }

        public Criteria andSubscriptBickidIn(List<String> values) {
            addCriterion("SUBSCRIPT_BICKID in", values, "subscriptBickid");
            return (Criteria) this;
        }

        public Criteria andSubscriptBickidNotIn(List<String> values) {
            addCriterion("SUBSCRIPT_BICKID not in", values, "subscriptBickid");
            return (Criteria) this;
        }

        public Criteria andSubscriptBickidBetween(String value1, String value2) {
            addCriterion("SUBSCRIPT_BICKID between", value1, value2, "subscriptBickid");
            return (Criteria) this;
        }

        public Criteria andSubscriptBickidNotBetween(String value1, String value2) {
            addCriterion("SUBSCRIPT_BICKID not between", value1, value2, "subscriptBickid");
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

        public Criteria andMonthIsNull() {
            addCriterion("`MONTH` is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("`MONTH` is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(String value) {
            addCriterion("`MONTH` =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(String value) {
            addCriterion("`MONTH` <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(String value) {
            addCriterion("`MONTH` >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(String value) {
            addCriterion("`MONTH` >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(String value) {
            addCriterion("`MONTH` <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(String value) {
            addCriterion("`MONTH` <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLike(String value) {
            addCriterion("`MONTH` like", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotLike(String value) {
            addCriterion("`MONTH` not like", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<String> values) {
            addCriterion("`MONTH` in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<String> values) {
            addCriterion("`MONTH` not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(String value1, String value2) {
            addCriterion("`MONTH` between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(String value1, String value2) {
            addCriterion("`MONTH` not between", value1, value2, "month");
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