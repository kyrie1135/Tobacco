package com.Lph.admin.satisfysurveytarget.model;

import java.util.ArrayList;
import java.util.List;

public class TCCSatisfysurveytargetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public TCCSatisfysurveytargetExample() {
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

        public Criteria andEvaluateTargetIsNull() {
            addCriterion("EVALUATE_TARGET is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateTargetIsNotNull() {
            addCriterion("EVALUATE_TARGET is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateTargetEqualTo(Double value) {
            addCriterion("EVALUATE_TARGET =", value, "evaluateTarget");
            return (Criteria) this;
        }

        public Criteria andEvaluateTargetNotEqualTo(Double value) {
            addCriterion("EVALUATE_TARGET <>", value, "evaluateTarget");
            return (Criteria) this;
        }

        public Criteria andEvaluateTargetGreaterThan(Double value) {
            addCriterion("EVALUATE_TARGET >", value, "evaluateTarget");
            return (Criteria) this;
        }

        public Criteria andEvaluateTargetGreaterThanOrEqualTo(Double value) {
            addCriterion("EVALUATE_TARGET >=", value, "evaluateTarget");
            return (Criteria) this;
        }

        public Criteria andEvaluateTargetLessThan(Double value) {
            addCriterion("EVALUATE_TARGET <", value, "evaluateTarget");
            return (Criteria) this;
        }

        public Criteria andEvaluateTargetLessThanOrEqualTo(Double value) {
            addCriterion("EVALUATE_TARGET <=", value, "evaluateTarget");
            return (Criteria) this;
        }

        public Criteria andEvaluateTargetIn(List<Double> values) {
            addCriterion("EVALUATE_TARGET in", values, "evaluateTarget");
            return (Criteria) this;
        }

        public Criteria andEvaluateTargetNotIn(List<Double> values) {
            addCriterion("EVALUATE_TARGET not in", values, "evaluateTarget");
            return (Criteria) this;
        }

        public Criteria andEvaluateTargetBetween(Double value1, Double value2) {
            addCriterion("EVALUATE_TARGET between", value1, value2, "evaluateTarget");
            return (Criteria) this;
        }

        public Criteria andEvaluateTargetNotBetween(Double value1, Double value2) {
            addCriterion("EVALUATE_TARGET not between", value1, value2, "evaluateTarget");
            return (Criteria) this;
        }

        public Criteria andEvaluateStandardIsNull() {
            addCriterion("EVALUATE_STANDARD is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateStandardIsNotNull() {
            addCriterion("EVALUATE_STANDARD is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateStandardEqualTo(String value) {
            addCriterion("EVALUATE_STANDARD =", value, "evaluateStandard");
            return (Criteria) this;
        }

        public Criteria andEvaluateStandardNotEqualTo(String value) {
            addCriterion("EVALUATE_STANDARD <>", value, "evaluateStandard");
            return (Criteria) this;
        }

        public Criteria andEvaluateStandardGreaterThan(String value) {
            addCriterion("EVALUATE_STANDARD >", value, "evaluateStandard");
            return (Criteria) this;
        }

        public Criteria andEvaluateStandardGreaterThanOrEqualTo(String value) {
            addCriterion("EVALUATE_STANDARD >=", value, "evaluateStandard");
            return (Criteria) this;
        }

        public Criteria andEvaluateStandardLessThan(String value) {
            addCriterion("EVALUATE_STANDARD <", value, "evaluateStandard");
            return (Criteria) this;
        }

        public Criteria andEvaluateStandardLessThanOrEqualTo(String value) {
            addCriterion("EVALUATE_STANDARD <=", value, "evaluateStandard");
            return (Criteria) this;
        }

        public Criteria andEvaluateStandardLike(String value) {
            addCriterion("EVALUATE_STANDARD like", value, "evaluateStandard");
            return (Criteria) this;
        }

        public Criteria andEvaluateStandardNotLike(String value) {
            addCriterion("EVALUATE_STANDARD not like", value, "evaluateStandard");
            return (Criteria) this;
        }

        public Criteria andEvaluateStandardIn(List<String> values) {
            addCriterion("EVALUATE_STANDARD in", values, "evaluateStandard");
            return (Criteria) this;
        }

        public Criteria andEvaluateStandardNotIn(List<String> values) {
            addCriterion("EVALUATE_STANDARD not in", values, "evaluateStandard");
            return (Criteria) this;
        }

        public Criteria andEvaluateStandardBetween(String value1, String value2) {
            addCriterion("EVALUATE_STANDARD between", value1, value2, "evaluateStandard");
            return (Criteria) this;
        }

        public Criteria andEvaluateStandardNotBetween(String value1, String value2) {
            addCriterion("EVALUATE_STANDARD not between", value1, value2, "evaluateStandard");
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