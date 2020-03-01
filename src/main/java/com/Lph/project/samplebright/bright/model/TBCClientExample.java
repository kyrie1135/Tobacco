package com.Lph.project.samplebright.bright.model;

import java.util.ArrayList;
import java.util.List;

public class TBCClientExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public TBCClientExample() {
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

        public Criteria andFacilityNumIsNull() {
            addCriterion("FACILITY_NUM is null");
            return (Criteria) this;
        }

        public Criteria andFacilityNumIsNotNull() {
            addCriterion("FACILITY_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andFacilityNumEqualTo(String value) {
            addCriterion("FACILITY_NUM =", value, "facilityNum");
            return (Criteria) this;
        }

        public Criteria andFacilityNumNotEqualTo(String value) {
            addCriterion("FACILITY_NUM <>", value, "facilityNum");
            return (Criteria) this;
        }

        public Criteria andFacilityNumGreaterThan(String value) {
            addCriterion("FACILITY_NUM >", value, "facilityNum");
            return (Criteria) this;
        }

        public Criteria andFacilityNumGreaterThanOrEqualTo(String value) {
            addCriterion("FACILITY_NUM >=", value, "facilityNum");
            return (Criteria) this;
        }

        public Criteria andFacilityNumLessThan(String value) {
            addCriterion("FACILITY_NUM <", value, "facilityNum");
            return (Criteria) this;
        }

        public Criteria andFacilityNumLessThanOrEqualTo(String value) {
            addCriterion("FACILITY_NUM <=", value, "facilityNum");
            return (Criteria) this;
        }

        public Criteria andFacilityNumLike(String value) {
            addCriterion("FACILITY_NUM like", value, "facilityNum");
            return (Criteria) this;
        }

        public Criteria andFacilityNumNotLike(String value) {
            addCriterion("FACILITY_NUM not like", value, "facilityNum");
            return (Criteria) this;
        }

        public Criteria andFacilityNumIn(List<String> values) {
            addCriterion("FACILITY_NUM in", values, "facilityNum");
            return (Criteria) this;
        }

        public Criteria andFacilityNumNotIn(List<String> values) {
            addCriterion("FACILITY_NUM not in", values, "facilityNum");
            return (Criteria) this;
        }

        public Criteria andFacilityNumBetween(String value1, String value2) {
            addCriterion("FACILITY_NUM between", value1, value2, "facilityNum");
            return (Criteria) this;
        }

        public Criteria andFacilityNumNotBetween(String value1, String value2) {
            addCriterion("FACILITY_NUM not between", value1, value2, "facilityNum");
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

        public Criteria andVsLineIsNull() {
            addCriterion("VS_LINE is null");
            return (Criteria) this;
        }

        public Criteria andVsLineIsNotNull() {
            addCriterion("VS_LINE is not null");
            return (Criteria) this;
        }

        public Criteria andVsLineEqualTo(String value) {
            addCriterion("VS_LINE =", value, "vsLine");
            return (Criteria) this;
        }

        public Criteria andVsLineNotEqualTo(String value) {
            addCriterion("VS_LINE <>", value, "vsLine");
            return (Criteria) this;
        }

        public Criteria andVsLineGreaterThan(String value) {
            addCriterion("VS_LINE >", value, "vsLine");
            return (Criteria) this;
        }

        public Criteria andVsLineGreaterThanOrEqualTo(String value) {
            addCriterion("VS_LINE >=", value, "vsLine");
            return (Criteria) this;
        }

        public Criteria andVsLineLessThan(String value) {
            addCriterion("VS_LINE <", value, "vsLine");
            return (Criteria) this;
        }

        public Criteria andVsLineLessThanOrEqualTo(String value) {
            addCriterion("VS_LINE <=", value, "vsLine");
            return (Criteria) this;
        }

        public Criteria andVsLineLike(String value) {
            addCriterion("VS_LINE like", value, "vsLine");
            return (Criteria) this;
        }

        public Criteria andVsLineNotLike(String value) {
            addCriterion("VS_LINE not like", value, "vsLine");
            return (Criteria) this;
        }

        public Criteria andVsLineIn(List<String> values) {
            addCriterion("VS_LINE in", values, "vsLine");
            return (Criteria) this;
        }

        public Criteria andVsLineNotIn(List<String> values) {
            addCriterion("VS_LINE not in", values, "vsLine");
            return (Criteria) this;
        }

        public Criteria andVsLineBetween(String value1, String value2) {
            addCriterion("VS_LINE between", value1, value2, "vsLine");
            return (Criteria) this;
        }

        public Criteria andVsLineNotBetween(String value1, String value2) {
            addCriterion("VS_LINE not between", value1, value2, "vsLine");
            return (Criteria) this;
        }

        public Criteria andCallLineIsNull() {
            addCriterion("CALL_LINE is null");
            return (Criteria) this;
        }

        public Criteria andCallLineIsNotNull() {
            addCriterion("CALL_LINE is not null");
            return (Criteria) this;
        }

        public Criteria andCallLineEqualTo(String value) {
            addCriterion("CALL_LINE =", value, "callLine");
            return (Criteria) this;
        }

        public Criteria andCallLineNotEqualTo(String value) {
            addCriterion("CALL_LINE <>", value, "callLine");
            return (Criteria) this;
        }

        public Criteria andCallLineGreaterThan(String value) {
            addCriterion("CALL_LINE >", value, "callLine");
            return (Criteria) this;
        }

        public Criteria andCallLineGreaterThanOrEqualTo(String value) {
            addCriterion("CALL_LINE >=", value, "callLine");
            return (Criteria) this;
        }

        public Criteria andCallLineLessThan(String value) {
            addCriterion("CALL_LINE <", value, "callLine");
            return (Criteria) this;
        }

        public Criteria andCallLineLessThanOrEqualTo(String value) {
            addCriterion("CALL_LINE <=", value, "callLine");
            return (Criteria) this;
        }

        public Criteria andCallLineLike(String value) {
            addCriterion("CALL_LINE like", value, "callLine");
            return (Criteria) this;
        }

        public Criteria andCallLineNotLike(String value) {
            addCriterion("CALL_LINE not like", value, "callLine");
            return (Criteria) this;
        }

        public Criteria andCallLineIn(List<String> values) {
            addCriterion("CALL_LINE in", values, "callLine");
            return (Criteria) this;
        }

        public Criteria andCallLineNotIn(List<String> values) {
            addCriterion("CALL_LINE not in", values, "callLine");
            return (Criteria) this;
        }

        public Criteria andCallLineBetween(String value1, String value2) {
            addCriterion("CALL_LINE between", value1, value2, "callLine");
            return (Criteria) this;
        }

        public Criteria andCallLineNotBetween(String value1, String value2) {
            addCriterion("CALL_LINE not between", value1, value2, "callLine");
            return (Criteria) this;
        }

        public Criteria andDeliverLineIsNull() {
            addCriterion("DELIVER_LINE is null");
            return (Criteria) this;
        }

        public Criteria andDeliverLineIsNotNull() {
            addCriterion("DELIVER_LINE is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverLineEqualTo(String value) {
            addCriterion("DELIVER_LINE =", value, "deliverLine");
            return (Criteria) this;
        }

        public Criteria andDeliverLineNotEqualTo(String value) {
            addCriterion("DELIVER_LINE <>", value, "deliverLine");
            return (Criteria) this;
        }

        public Criteria andDeliverLineGreaterThan(String value) {
            addCriterion("DELIVER_LINE >", value, "deliverLine");
            return (Criteria) this;
        }

        public Criteria andDeliverLineGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVER_LINE >=", value, "deliverLine");
            return (Criteria) this;
        }

        public Criteria andDeliverLineLessThan(String value) {
            addCriterion("DELIVER_LINE <", value, "deliverLine");
            return (Criteria) this;
        }

        public Criteria andDeliverLineLessThanOrEqualTo(String value) {
            addCriterion("DELIVER_LINE <=", value, "deliverLine");
            return (Criteria) this;
        }

        public Criteria andDeliverLineLike(String value) {
            addCriterion("DELIVER_LINE like", value, "deliverLine");
            return (Criteria) this;
        }

        public Criteria andDeliverLineNotLike(String value) {
            addCriterion("DELIVER_LINE not like", value, "deliverLine");
            return (Criteria) this;
        }

        public Criteria andDeliverLineIn(List<String> values) {
            addCriterion("DELIVER_LINE in", values, "deliverLine");
            return (Criteria) this;
        }

        public Criteria andDeliverLineNotIn(List<String> values) {
            addCriterion("DELIVER_LINE not in", values, "deliverLine");
            return (Criteria) this;
        }

        public Criteria andDeliverLineBetween(String value1, String value2) {
            addCriterion("DELIVER_LINE between", value1, value2, "deliverLine");
            return (Criteria) this;
        }

        public Criteria andDeliverLineNotBetween(String value1, String value2) {
            addCriterion("DELIVER_LINE not between", value1, value2, "deliverLine");
            return (Criteria) this;
        }

        public Criteria andBigCorpCodeIsNull() {
            addCriterion("BIG_CORP_CODE is null");
            return (Criteria) this;
        }

        public Criteria andBigCorpCodeIsNotNull() {
            addCriterion("BIG_CORP_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andBigCorpCodeEqualTo(String value) {
            addCriterion("BIG_CORP_CODE =", value, "bigCorpCode");
            return (Criteria) this;
        }

        public Criteria andBigCorpCodeNotEqualTo(String value) {
            addCriterion("BIG_CORP_CODE <>", value, "bigCorpCode");
            return (Criteria) this;
        }

        public Criteria andBigCorpCodeGreaterThan(String value) {
            addCriterion("BIG_CORP_CODE >", value, "bigCorpCode");
            return (Criteria) this;
        }

        public Criteria andBigCorpCodeGreaterThanOrEqualTo(String value) {
            addCriterion("BIG_CORP_CODE >=", value, "bigCorpCode");
            return (Criteria) this;
        }

        public Criteria andBigCorpCodeLessThan(String value) {
            addCriterion("BIG_CORP_CODE <", value, "bigCorpCode");
            return (Criteria) this;
        }

        public Criteria andBigCorpCodeLessThanOrEqualTo(String value) {
            addCriterion("BIG_CORP_CODE <=", value, "bigCorpCode");
            return (Criteria) this;
        }

        public Criteria andBigCorpCodeLike(String value) {
            addCriterion("BIG_CORP_CODE like", value, "bigCorpCode");
            return (Criteria) this;
        }

        public Criteria andBigCorpCodeNotLike(String value) {
            addCriterion("BIG_CORP_CODE not like", value, "bigCorpCode");
            return (Criteria) this;
        }

        public Criteria andBigCorpCodeIn(List<String> values) {
            addCriterion("BIG_CORP_CODE in", values, "bigCorpCode");
            return (Criteria) this;
        }

        public Criteria andBigCorpCodeNotIn(List<String> values) {
            addCriterion("BIG_CORP_CODE not in", values, "bigCorpCode");
            return (Criteria) this;
        }

        public Criteria andBigCorpCodeBetween(String value1, String value2) {
            addCriterion("BIG_CORP_CODE between", value1, value2, "bigCorpCode");
            return (Criteria) this;
        }

        public Criteria andBigCorpCodeNotBetween(String value1, String value2) {
            addCriterion("BIG_CORP_CODE not between", value1, value2, "bigCorpCode");
            return (Criteria) this;
        }

        public Criteria andClientTypeCodeIsNull() {
            addCriterion("CLIENT_TYPE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andClientTypeCodeIsNotNull() {
            addCriterion("CLIENT_TYPE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andClientTypeCodeEqualTo(String value) {
            addCriterion("CLIENT_TYPE_CODE =", value, "clientTypeCode");
            return (Criteria) this;
        }

        public Criteria andClientTypeCodeNotEqualTo(String value) {
            addCriterion("CLIENT_TYPE_CODE <>", value, "clientTypeCode");
            return (Criteria) this;
        }

        public Criteria andClientTypeCodeGreaterThan(String value) {
            addCriterion("CLIENT_TYPE_CODE >", value, "clientTypeCode");
            return (Criteria) this;
        }

        public Criteria andClientTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CLIENT_TYPE_CODE >=", value, "clientTypeCode");
            return (Criteria) this;
        }

        public Criteria andClientTypeCodeLessThan(String value) {
            addCriterion("CLIENT_TYPE_CODE <", value, "clientTypeCode");
            return (Criteria) this;
        }

        public Criteria andClientTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("CLIENT_TYPE_CODE <=", value, "clientTypeCode");
            return (Criteria) this;
        }

        public Criteria andClientTypeCodeLike(String value) {
            addCriterion("CLIENT_TYPE_CODE like", value, "clientTypeCode");
            return (Criteria) this;
        }

        public Criteria andClientTypeCodeNotLike(String value) {
            addCriterion("CLIENT_TYPE_CODE not like", value, "clientTypeCode");
            return (Criteria) this;
        }

        public Criteria andClientTypeCodeIn(List<String> values) {
            addCriterion("CLIENT_TYPE_CODE in", values, "clientTypeCode");
            return (Criteria) this;
        }

        public Criteria andClientTypeCodeNotIn(List<String> values) {
            addCriterion("CLIENT_TYPE_CODE not in", values, "clientTypeCode");
            return (Criteria) this;
        }

        public Criteria andClientTypeCodeBetween(String value1, String value2) {
            addCriterion("CLIENT_TYPE_CODE between", value1, value2, "clientTypeCode");
            return (Criteria) this;
        }

        public Criteria andClientTypeCodeNotBetween(String value1, String value2) {
            addCriterion("CLIENT_TYPE_CODE not between", value1, value2, "clientTypeCode");
            return (Criteria) this;
        }

        public Criteria andWorkStateIsNull() {
            addCriterion("WORK_STATE is null");
            return (Criteria) this;
        }

        public Criteria andWorkStateIsNotNull() {
            addCriterion("WORK_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andWorkStateEqualTo(String value) {
            addCriterion("WORK_STATE =", value, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateNotEqualTo(String value) {
            addCriterion("WORK_STATE <>", value, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateGreaterThan(String value) {
            addCriterion("WORK_STATE >", value, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_STATE >=", value, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateLessThan(String value) {
            addCriterion("WORK_STATE <", value, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateLessThanOrEqualTo(String value) {
            addCriterion("WORK_STATE <=", value, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateLike(String value) {
            addCriterion("WORK_STATE like", value, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateNotLike(String value) {
            addCriterion("WORK_STATE not like", value, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateIn(List<String> values) {
            addCriterion("WORK_STATE in", values, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateNotIn(List<String> values) {
            addCriterion("WORK_STATE not in", values, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateBetween(String value1, String value2) {
            addCriterion("WORK_STATE between", value1, value2, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateNotBetween(String value1, String value2) {
            addCriterion("WORK_STATE not between", value1, value2, "workState");
            return (Criteria) this;
        }

        public Criteria andClientMgrIsNull() {
            addCriterion("CLIENT_MGR is null");
            return (Criteria) this;
        }

        public Criteria andClientMgrIsNotNull() {
            addCriterion("CLIENT_MGR is not null");
            return (Criteria) this;
        }

        public Criteria andClientMgrEqualTo(String value) {
            addCriterion("CLIENT_MGR =", value, "clientMgr");
            return (Criteria) this;
        }

        public Criteria andClientMgrNotEqualTo(String value) {
            addCriterion("CLIENT_MGR <>", value, "clientMgr");
            return (Criteria) this;
        }

        public Criteria andClientMgrGreaterThan(String value) {
            addCriterion("CLIENT_MGR >", value, "clientMgr");
            return (Criteria) this;
        }

        public Criteria andClientMgrGreaterThanOrEqualTo(String value) {
            addCriterion("CLIENT_MGR >=", value, "clientMgr");
            return (Criteria) this;
        }

        public Criteria andClientMgrLessThan(String value) {
            addCriterion("CLIENT_MGR <", value, "clientMgr");
            return (Criteria) this;
        }

        public Criteria andClientMgrLessThanOrEqualTo(String value) {
            addCriterion("CLIENT_MGR <=", value, "clientMgr");
            return (Criteria) this;
        }

        public Criteria andClientMgrLike(String value) {
            addCriterion("CLIENT_MGR like", value, "clientMgr");
            return (Criteria) this;
        }

        public Criteria andClientMgrNotLike(String value) {
            addCriterion("CLIENT_MGR not like", value, "clientMgr");
            return (Criteria) this;
        }

        public Criteria andClientMgrIn(List<String> values) {
            addCriterion("CLIENT_MGR in", values, "clientMgr");
            return (Criteria) this;
        }

        public Criteria andClientMgrNotIn(List<String> values) {
            addCriterion("CLIENT_MGR not in", values, "clientMgr");
            return (Criteria) this;
        }

        public Criteria andClientMgrBetween(String value1, String value2) {
            addCriterion("CLIENT_MGR between", value1, value2, "clientMgr");
            return (Criteria) this;
        }

        public Criteria andClientMgrNotBetween(String value1, String value2) {
            addCriterion("CLIENT_MGR not between", value1, value2, "clientMgr");
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