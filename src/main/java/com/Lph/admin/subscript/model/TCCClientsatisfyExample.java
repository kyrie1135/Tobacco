package com.Lph.admin.subscript.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TCCClientsatisfyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public TCCClientsatisfyExample() {
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

        public Criteria andTargetSortIsNull() {
            addCriterion("TARGET_SORT is null");
            return (Criteria) this;
        }

        public Criteria andTargetSortIsNotNull() {
            addCriterion("TARGET_SORT is not null");
            return (Criteria) this;
        }

        public Criteria andTargetSortEqualTo(String value) {
            addCriterion("TARGET_SORT =", value, "targetSort");
            return (Criteria) this;
        }

        public Criteria andTargetSortNotEqualTo(String value) {
            addCriterion("TARGET_SORT <>", value, "targetSort");
            return (Criteria) this;
        }

        public Criteria andTargetSortGreaterThan(String value) {
            addCriterion("TARGET_SORT >", value, "targetSort");
            return (Criteria) this;
        }

        public Criteria andTargetSortGreaterThanOrEqualTo(String value) {
            addCriterion("TARGET_SORT >=", value, "targetSort");
            return (Criteria) this;
        }

        public Criteria andTargetSortLessThan(String value) {
            addCriterion("TARGET_SORT <", value, "targetSort");
            return (Criteria) this;
        }

        public Criteria andTargetSortLessThanOrEqualTo(String value) {
            addCriterion("TARGET_SORT <=", value, "targetSort");
            return (Criteria) this;
        }

        public Criteria andTargetSortLike(String value) {
            addCriterion("TARGET_SORT like", value, "targetSort");
            return (Criteria) this;
        }

        public Criteria andTargetSortNotLike(String value) {
            addCriterion("TARGET_SORT not like", value, "targetSort");
            return (Criteria) this;
        }

        public Criteria andTargetSortIn(List<String> values) {
            addCriterion("TARGET_SORT in", values, "targetSort");
            return (Criteria) this;
        }

        public Criteria andTargetSortNotIn(List<String> values) {
            addCriterion("TARGET_SORT not in", values, "targetSort");
            return (Criteria) this;
        }

        public Criteria andTargetSortBetween(String value1, String value2) {
            addCriterion("TARGET_SORT between", value1, value2, "targetSort");
            return (Criteria) this;
        }

        public Criteria andTargetSortNotBetween(String value1, String value2) {
            addCriterion("TARGET_SORT not between", value1, value2, "targetSort");
            return (Criteria) this;
        }

        public Criteria andEvaluateItemIsNull() {
            addCriterion("EVALUATE_ITEM is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateItemIsNotNull() {
            addCriterion("EVALUATE_ITEM is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateItemEqualTo(String value) {
            addCriterion("EVALUATE_ITEM =", value, "evaluateItem");
            return (Criteria) this;
        }

        public Criteria andEvaluateItemNotEqualTo(String value) {
            addCriterion("EVALUATE_ITEM <>", value, "evaluateItem");
            return (Criteria) this;
        }

        public Criteria andEvaluateItemGreaterThan(String value) {
            addCriterion("EVALUATE_ITEM >", value, "evaluateItem");
            return (Criteria) this;
        }

        public Criteria andEvaluateItemGreaterThanOrEqualTo(String value) {
            addCriterion("EVALUATE_ITEM >=", value, "evaluateItem");
            return (Criteria) this;
        }

        public Criteria andEvaluateItemLessThan(String value) {
            addCriterion("EVALUATE_ITEM <", value, "evaluateItem");
            return (Criteria) this;
        }

        public Criteria andEvaluateItemLessThanOrEqualTo(String value) {
            addCriterion("EVALUATE_ITEM <=", value, "evaluateItem");
            return (Criteria) this;
        }

        public Criteria andEvaluateItemLike(String value) {
            addCriterion("EVALUATE_ITEM like", value, "evaluateItem");
            return (Criteria) this;
        }

        public Criteria andEvaluateItemNotLike(String value) {
            addCriterion("EVALUATE_ITEM not like", value, "evaluateItem");
            return (Criteria) this;
        }

        public Criteria andEvaluateItemIn(List<String> values) {
            addCriterion("EVALUATE_ITEM in", values, "evaluateItem");
            return (Criteria) this;
        }

        public Criteria andEvaluateItemNotIn(List<String> values) {
            addCriterion("EVALUATE_ITEM not in", values, "evaluateItem");
            return (Criteria) this;
        }

        public Criteria andEvaluateItemBetween(String value1, String value2) {
            addCriterion("EVALUATE_ITEM between", value1, value2, "evaluateItem");
            return (Criteria) this;
        }

        public Criteria andEvaluateItemNotBetween(String value1, String value2) {
            addCriterion("EVALUATE_ITEM not between", value1, value2, "evaluateItem");
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

        public Criteria andEvaluateTargetEqualTo(String value) {
            addCriterion("EVALUATE_TARGET =", value, "evaluateTarget");
            return (Criteria) this;
        }

        public Criteria andEvaluateTargetNotEqualTo(String value) {
            addCriterion("EVALUATE_TARGET <>", value, "evaluateTarget");
            return (Criteria) this;
        }

        public Criteria andEvaluateTargetGreaterThan(String value) {
            addCriterion("EVALUATE_TARGET >", value, "evaluateTarget");
            return (Criteria) this;
        }

        public Criteria andEvaluateTargetGreaterThanOrEqualTo(String value) {
            addCriterion("EVALUATE_TARGET >=", value, "evaluateTarget");
            return (Criteria) this;
        }

        public Criteria andEvaluateTargetLessThan(String value) {
            addCriterion("EVALUATE_TARGET <", value, "evaluateTarget");
            return (Criteria) this;
        }

        public Criteria andEvaluateTargetLessThanOrEqualTo(String value) {
            addCriterion("EVALUATE_TARGET <=", value, "evaluateTarget");
            return (Criteria) this;
        }

        public Criteria andEvaluateTargetLike(String value) {
            addCriterion("EVALUATE_TARGET like", value, "evaluateTarget");
            return (Criteria) this;
        }

        public Criteria andEvaluateTargetNotLike(String value) {
            addCriterion("EVALUATE_TARGET not like", value, "evaluateTarget");
            return (Criteria) this;
        }

        public Criteria andEvaluateTargetIn(List<String> values) {
            addCriterion("EVALUATE_TARGET in", values, "evaluateTarget");
            return (Criteria) this;
        }

        public Criteria andEvaluateTargetNotIn(List<String> values) {
            addCriterion("EVALUATE_TARGET not in", values, "evaluateTarget");
            return (Criteria) this;
        }

        public Criteria andEvaluateTargetBetween(String value1, String value2) {
            addCriterion("EVALUATE_TARGET between", value1, value2, "evaluateTarget");
            return (Criteria) this;
        }

        public Criteria andEvaluateTargetNotBetween(String value1, String value2) {
            addCriterion("EVALUATE_TARGET not between", value1, value2, "evaluateTarget");
            return (Criteria) this;
        }

        public Criteria andIsUseIsNull() {
            addCriterion("IS_USE is null");
            return (Criteria) this;
        }

        public Criteria andIsUseIsNotNull() {
            addCriterion("IS_USE is not null");
            return (Criteria) this;
        }

        public Criteria andIsUseEqualTo(String value) {
            addCriterion("IS_USE =", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotEqualTo(String value) {
            addCriterion("IS_USE <>", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseGreaterThan(String value) {
            addCriterion("IS_USE >", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseGreaterThanOrEqualTo(String value) {
            addCriterion("IS_USE >=", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseLessThan(String value) {
            addCriterion("IS_USE <", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseLessThanOrEqualTo(String value) {
            addCriterion("IS_USE <=", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseLike(String value) {
            addCriterion("IS_USE like", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotLike(String value) {
            addCriterion("IS_USE not like", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseIn(List<String> values) {
            addCriterion("IS_USE in", values, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotIn(List<String> values) {
            addCriterion("IS_USE not in", values, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseBetween(String value1, String value2) {
            addCriterion("IS_USE between", value1, value2, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotBetween(String value1, String value2) {
            addCriterion("IS_USE not between", value1, value2, "isUse");
            return (Criteria) this;
        }

        public Criteria andEvaluateCycIsNull() {
            addCriterion("EVALUATE_CYC is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateCycIsNotNull() {
            addCriterion("EVALUATE_CYC is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateCycEqualTo(String value) {
            addCriterion("EVALUATE_CYC =", value, "evaluateCyc");
            return (Criteria) this;
        }

        public Criteria andEvaluateCycNotEqualTo(String value) {
            addCriterion("EVALUATE_CYC <>", value, "evaluateCyc");
            return (Criteria) this;
        }

        public Criteria andEvaluateCycGreaterThan(String value) {
            addCriterion("EVALUATE_CYC >", value, "evaluateCyc");
            return (Criteria) this;
        }

        public Criteria andEvaluateCycGreaterThanOrEqualTo(String value) {
            addCriterion("EVALUATE_CYC >=", value, "evaluateCyc");
            return (Criteria) this;
        }

        public Criteria andEvaluateCycLessThan(String value) {
            addCriterion("EVALUATE_CYC <", value, "evaluateCyc");
            return (Criteria) this;
        }

        public Criteria andEvaluateCycLessThanOrEqualTo(String value) {
            addCriterion("EVALUATE_CYC <=", value, "evaluateCyc");
            return (Criteria) this;
        }

        public Criteria andEvaluateCycLike(String value) {
            addCriterion("EVALUATE_CYC like", value, "evaluateCyc");
            return (Criteria) this;
        }

        public Criteria andEvaluateCycNotLike(String value) {
            addCriterion("EVALUATE_CYC not like", value, "evaluateCyc");
            return (Criteria) this;
        }

        public Criteria andEvaluateCycIn(List<String> values) {
            addCriterion("EVALUATE_CYC in", values, "evaluateCyc");
            return (Criteria) this;
        }

        public Criteria andEvaluateCycNotIn(List<String> values) {
            addCriterion("EVALUATE_CYC not in", values, "evaluateCyc");
            return (Criteria) this;
        }

        public Criteria andEvaluateCycBetween(String value1, String value2) {
            addCriterion("EVALUATE_CYC between", value1, value2, "evaluateCyc");
            return (Criteria) this;
        }

        public Criteria andEvaluateCycNotBetween(String value1, String value2) {
            addCriterion("EVALUATE_CYC not between", value1, value2, "evaluateCyc");
            return (Criteria) this;
        }

        public Criteria andProportionIsNull() {
            addCriterion("PROPORTION is null");
            return (Criteria) this;
        }

        public Criteria andProportionIsNotNull() {
            addCriterion("PROPORTION is not null");
            return (Criteria) this;
        }

        public Criteria andProportionEqualTo(BigDecimal value) {
            addCriterion("PROPORTION =", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionNotEqualTo(BigDecimal value) {
            addCriterion("PROPORTION <>", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionGreaterThan(BigDecimal value) {
            addCriterion("PROPORTION >", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPORTION >=", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionLessThan(BigDecimal value) {
            addCriterion("PROPORTION <", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPORTION <=", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionIn(List<BigDecimal> values) {
            addCriterion("PROPORTION in", values, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionNotIn(List<BigDecimal> values) {
            addCriterion("PROPORTION not in", values, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPORTION between", value1, value2, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPORTION not between", value1, value2, "proportion");
            return (Criteria) this;
        }

        public Criteria andEmpRoleIsNull() {
            addCriterion("EMP_ROLE is null");
            return (Criteria) this;
        }

        public Criteria andEmpRoleIsNotNull() {
            addCriterion("EMP_ROLE is not null");
            return (Criteria) this;
        }

        public Criteria andEmpRoleEqualTo(String value) {
            addCriterion("EMP_ROLE =", value, "empRole");
            return (Criteria) this;
        }

        public Criteria andEmpRoleNotEqualTo(String value) {
            addCriterion("EMP_ROLE <>", value, "empRole");
            return (Criteria) this;
        }

        public Criteria andEmpRoleGreaterThan(String value) {
            addCriterion("EMP_ROLE >", value, "empRole");
            return (Criteria) this;
        }

        public Criteria andEmpRoleGreaterThanOrEqualTo(String value) {
            addCriterion("EMP_ROLE >=", value, "empRole");
            return (Criteria) this;
        }

        public Criteria andEmpRoleLessThan(String value) {
            addCriterion("EMP_ROLE <", value, "empRole");
            return (Criteria) this;
        }

        public Criteria andEmpRoleLessThanOrEqualTo(String value) {
            addCriterion("EMP_ROLE <=", value, "empRole");
            return (Criteria) this;
        }

        public Criteria andEmpRoleLike(String value) {
            addCriterion("EMP_ROLE like", value, "empRole");
            return (Criteria) this;
        }

        public Criteria andEmpRoleNotLike(String value) {
            addCriterion("EMP_ROLE not like", value, "empRole");
            return (Criteria) this;
        }

        public Criteria andEmpRoleIn(List<String> values) {
            addCriterion("EMP_ROLE in", values, "empRole");
            return (Criteria) this;
        }

        public Criteria andEmpRoleNotIn(List<String> values) {
            addCriterion("EMP_ROLE not in", values, "empRole");
            return (Criteria) this;
        }

        public Criteria andEmpRoleBetween(String value1, String value2) {
            addCriterion("EMP_ROLE between", value1, value2, "empRole");
            return (Criteria) this;
        }

        public Criteria andEmpRoleNotBetween(String value1, String value2) {
            addCriterion("EMP_ROLE not between", value1, value2, "empRole");
            return (Criteria) this;
        }

        public Criteria andCreDateIsNull() {
            addCriterion("CRE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreDateIsNotNull() {
            addCriterion("CRE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreDateEqualTo(Date value) {
            addCriterionForJDBCDate("CRE_DATE =", value, "creDate");
            return (Criteria) this;
        }

        public Criteria andCreDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("CRE_DATE <>", value, "creDate");
            return (Criteria) this;
        }

        public Criteria andCreDateGreaterThan(Date value) {
            addCriterionForJDBCDate("CRE_DATE >", value, "creDate");
            return (Criteria) this;
        }

        public Criteria andCreDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CRE_DATE >=", value, "creDate");
            return (Criteria) this;
        }

        public Criteria andCreDateLessThan(Date value) {
            addCriterionForJDBCDate("CRE_DATE <", value, "creDate");
            return (Criteria) this;
        }

        public Criteria andCreDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CRE_DATE <=", value, "creDate");
            return (Criteria) this;
        }

        public Criteria andCreDateIn(List<Date> values) {
            addCriterionForJDBCDate("CRE_DATE in", values, "creDate");
            return (Criteria) this;
        }

        public Criteria andCreDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("CRE_DATE not in", values, "creDate");
            return (Criteria) this;
        }

        public Criteria andCreDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CRE_DATE between", value1, value2, "creDate");
            return (Criteria) this;
        }

        public Criteria andCreDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CRE_DATE not between", value1, value2, "creDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("END_DATE =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("END_DATE <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("END_DATE >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("END_DATE >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("END_DATE <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("END_DATE <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("END_DATE in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("END_DATE not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("END_DATE between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("END_DATE not between", value1, value2, "endDate");
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