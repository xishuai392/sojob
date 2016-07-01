package com.ztesoft.web.busiz.db.arg;

import java.util.*;
import java.math.*;
import org.apache.commons.lang.*;

public class UserBehaveArg {
    private String pk_name = "behav_id";

    private String orderByClause;

    private String groupByClause;

    private String columns;

    private String countsql1;

    private String countsql2;

    private boolean distinct;

    private int rowStart = 0;

    private int rowEnd = 10;

    private List<UserBehaveCriteria> oredCriteria;

    public UserBehaveArg() {
        oredCriteria = new ArrayList<UserBehaveCriteria>();
    }

    public void setPk_name(String pk_name) {
        this.pk_name = StringEscapeUtils.escapeSql(pk_name);
    }

    public String getPk_name() {
        return pk_name;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = StringEscapeUtils.escapeSql(orderByClause);
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setGroupByClause(String groupByClause) {
        this.groupByClause = StringEscapeUtils.escapeSql(groupByClause);
    }

    public String geGroupByClause() {
        return groupByClause;
    }

    public void setColumns(String columns) {
        this.columns = StringEscapeUtils.escapeSql(columns);
    }

    public String geColumns() {
        return columns;
    }

    public void setCountsql1(String countsql1) {
        this.countsql1 = StringEscapeUtils.escapeSql(countsql1);
    }

    public String geCountsql1() {
        return countsql1;
    }

    public void setCountsql2(String countsql2) {
        this.countsql2 = StringEscapeUtils.escapeSql(countsql2);
    }

    public String geCountsql2() {
        return countsql2;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setRowStart(int rowStart) {
        this.rowStart = rowStart;
    }

    public void setRowEnd(int rowEnd) {
        this.rowEnd = rowEnd;
    }

    public int getRowStart() {
        return rowStart;
    }

    public int getRowEnd() {
        return rowEnd;
    }

    public List<UserBehaveCriteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(UserBehaveCriteria criteria) {
        oredCriteria.add(criteria);
    }

    public UserBehaveCriteria or() {
    	UserBehaveCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public UserBehaveCriteria createCriteria() {
    	UserBehaveCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected UserBehaveCriteria createCriteriaInternal() {
    	UserBehaveCriteria criteria = new UserBehaveCriteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        groupByClause = null;
        columns = null;
        countsql1 = null;
        countsql2 = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<UserBehaveCriterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<UserBehaveCriterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<UserBehaveCriterion> getAllCriteria() {
            return criteria;
        }

        public List<UserBehaveCriterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new UserBehaveCriterion(condition));
        }

        protected void addCriterion(String condition, Object value,
                String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new UserBehaveCriterion(condition, value));
        }

        protected void addCriterion(String condition, Object value,
                String property, int likeType) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new UserBehaveCriterion(condition, value, likeType));
        }

        protected void addCriterion(String condition, Object value1,
                Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property
                        + " cannot be null");
            }
            criteria.add(new UserBehaveCriterion(condition, value1, value2));
        }

        public UserBehaveCriteria andCriterionEqualTo(String criterion) {
            if (StringUtils.isBlank(criterion)) {
                criterion = "1=1";
            }
            addCriterion(criterion);
            return (UserBehaveCriteria) this;
        }
        public UserBehaveCriteria andBehavIdIsNull() {
            addCriterion("behav_id is null");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andBehavIdIsNotNull() {
            addCriterion("behav_id is not null");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andBehavIdEqualTo(Integer value) {
            addCriterion("behav_id =", value, "behav_id");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andBehavIdNotEqualTo(Integer value) {
            addCriterion("behav_id <>", value, "behav_id");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andBehavIdGreaterThan(Integer value) {
            addCriterion("behav_id >", value, "behav_id");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andBehavIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("behav_id >=", value, "behav_id");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andBehavIdLessThan(Integer value) {
            addCriterion("behav_id <", value, "behav_id");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andBehavIdLessThanOrEqualTo(Integer value) {
            addCriterion("behav_id <=", value, "behav_id");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andBehavIdLike(Integer value) {
            addCriterion("behav_id like ", value, "behav_id", 1);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andBehavIdNotLike(Integer value) {
            addCriterion("behav_id  not like ", value, "behav_id", 1);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andBehavIdLeftLike(Integer value) {
            addCriterion("behav_id like ", value, "behav_id", 0);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andBehavIdNotLeftLike(Integer value) {
            addCriterion("behav_id  not like ", value, "behav_id", 0);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andBehavIdRightLike(Integer value) {
            addCriterion("behav_id like ", value, "behav_id", 2);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andBehavIdNotRightLike(Integer value) {
            addCriterion("behav_id  not like ", value, "behav_id", 2);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andBehavIdIn(List<Integer> values) {
            addCriterion("behav_id  in ", values, "behav_id");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andBehavIdNotIn(List<Integer> values) {
            addCriterion("behav_id not in ", values, "behav_id");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andBehavIdBetween(Integer value1, Integer value2) {
            addCriterion("behav_id between ", value1, value2, "behav_id");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andBehavIdNotBetween(Integer value1, Integer value2) {
            addCriterion("behav_id not between ", value1, value2, "behav_id");
            return (UserBehaveCriteria) this;
        }
        public UserBehaveCriteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "user_id");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "user_id");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "user_id");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "user_id");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "user_id");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "user_id");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserIdLike(Integer value) {
            addCriterion("user_id like ", value, "user_id", 1);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserIdNotLike(Integer value) {
            addCriterion("user_id  not like ", value, "user_id", 1);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserIdLeftLike(Integer value) {
            addCriterion("user_id like ", value, "user_id", 0);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserIdNotLeftLike(Integer value) {
            addCriterion("user_id  not like ", value, "user_id", 0);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserIdRightLike(Integer value) {
            addCriterion("user_id like ", value, "user_id", 2);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserIdNotRightLike(Integer value) {
            addCriterion("user_id  not like ", value, "user_id", 2);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id  in ", values, "user_id");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in ", values, "user_id");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between ", value1, value2, "user_id");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between ", value1, value2, "user_id");
            return (UserBehaveCriteria) this;
        }
        public UserBehaveCriteria andDeviceCodeIsNull() {
            addCriterion("device_code is null");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceCodeIsNotNull() {
            addCriterion("device_code is not null");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceCodeEqualTo(String value) {
            addCriterion("device_code =", value, "device_code");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceCodeNotEqualTo(String value) {
            addCriterion("device_code <>", value, "device_code");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceCodeGreaterThan(String value) {
            addCriterion("device_code >", value, "device_code");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("device_code >=", value, "device_code");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceCodeLessThan(String value) {
            addCriterion("device_code <", value, "device_code");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceCodeLessThanOrEqualTo(String value) {
            addCriterion("device_code <=", value, "device_code");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceCodeLike(String value) {
            addCriterion("device_code like ", value, "device_code", 1);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceCodeNotLike(String value) {
            addCriterion("device_code  not like ", value, "device_code", 1);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceCodeLeftLike(String value) {
            addCriterion("device_code like ", value, "device_code", 0);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceCodeNotLeftLike(String value) {
            addCriterion("device_code  not like ", value, "device_code", 0);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceCodeRightLike(String value) {
            addCriterion("device_code like ", value, "device_code", 2);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceCodeNotRightLike(String value) {
            addCriterion("device_code  not like ", value, "device_code", 2);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceCodeIn(List<String> values) {
            addCriterion("device_code  in ", values, "device_code");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceCodeNotIn(List<String> values) {
            addCriterion("device_code not in ", values, "device_code");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceCodeBetween(String value1, String value2) {
            addCriterion("device_code between ", value1, value2, "device_code");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceCodeNotBetween(String value1, String value2) {
            addCriterion("device_code not between ", value1, value2, "device_code");
            return (UserBehaveCriteria) this;
        }
        public UserBehaveCriteria andDeviceTypeIsNull() {
            addCriterion("device_type is null");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceTypeIsNotNull() {
            addCriterion("device_type is not null");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceTypeEqualTo(String value) {
            addCriterion("device_type =", value, "device_type");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceTypeNotEqualTo(String value) {
            addCriterion("device_type <>", value, "device_type");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceTypeGreaterThan(String value) {
            addCriterion("device_type >", value, "device_type");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("device_type >=", value, "device_type");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceTypeLessThan(String value) {
            addCriterion("device_type <", value, "device_type");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceTypeLessThanOrEqualTo(String value) {
            addCriterion("device_type <=", value, "device_type");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceTypeLike(String value) {
            addCriterion("device_type like ", value, "device_type", 1);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceTypeNotLike(String value) {
            addCriterion("device_type  not like ", value, "device_type", 1);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceTypeLeftLike(String value) {
            addCriterion("device_type like ", value, "device_type", 0);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceTypeNotLeftLike(String value) {
            addCriterion("device_type  not like ", value, "device_type", 0);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceTypeRightLike(String value) {
            addCriterion("device_type like ", value, "device_type", 2);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceTypeNotRightLike(String value) {
            addCriterion("device_type  not like ", value, "device_type", 2);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceTypeIn(List<String> values) {
            addCriterion("device_type  in ", values, "device_type");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceTypeNotIn(List<String> values) {
            addCriterion("device_type not in ", values, "device_type");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceTypeBetween(String value1, String value2) {
            addCriterion("device_type between ", value1, value2, "device_type");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andDeviceTypeNotBetween(String value1, String value2) {
            addCriterion("device_type not between ", value1, value2, "device_type");
            return (UserBehaveCriteria) this;
        }
        public UserBehaveCriteria andSysTypeIsNull() {
            addCriterion("sys_type is null");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysTypeIsNotNull() {
            addCriterion("sys_type is not null");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysTypeEqualTo(Integer value) {
            addCriterion("sys_type =", value, "sys_type");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysTypeNotEqualTo(Integer value) {
            addCriterion("sys_type <>", value, "sys_type");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysTypeGreaterThan(Integer value) {
            addCriterion("sys_type >", value, "sys_type");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_type >=", value, "sys_type");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysTypeLessThan(Integer value) {
            addCriterion("sys_type <", value, "sys_type");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysTypeLessThanOrEqualTo(Integer value) {
            addCriterion("sys_type <=", value, "sys_type");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysTypeLike(Integer value) {
            addCriterion("sys_type like ", value, "sys_type", 1);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysTypeNotLike(Integer value) {
            addCriterion("sys_type  not like ", value, "sys_type", 1);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysTypeLeftLike(Integer value) {
            addCriterion("sys_type like ", value, "sys_type", 0);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysTypeNotLeftLike(Integer value) {
            addCriterion("sys_type  not like ", value, "sys_type", 0);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysTypeRightLike(Integer value) {
            addCriterion("sys_type like ", value, "sys_type", 2);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysTypeNotRightLike(Integer value) {
            addCriterion("sys_type  not like ", value, "sys_type", 2);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysTypeIn(List<Integer> values) {
            addCriterion("sys_type  in ", values, "sys_type");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysTypeNotIn(List<Integer> values) {
            addCriterion("sys_type not in ", values, "sys_type");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysTypeBetween(Integer value1, Integer value2) {
            addCriterion("sys_type between ", value1, value2, "sys_type");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_type not between ", value1, value2, "sys_type");
            return (UserBehaveCriteria) this;
        }
        public UserBehaveCriteria andSysVersionIsNull() {
            addCriterion("sys_version is null");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysVersionIsNotNull() {
            addCriterion("sys_version is not null");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysVersionEqualTo(String value) {
            addCriterion("sys_version =", value, "sys_version");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysVersionNotEqualTo(String value) {
            addCriterion("sys_version <>", value, "sys_version");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysVersionGreaterThan(String value) {
            addCriterion("sys_version >", value, "sys_version");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysVersionGreaterThanOrEqualTo(String value) {
            addCriterion("sys_version >=", value, "sys_version");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysVersionLessThan(String value) {
            addCriterion("sys_version <", value, "sys_version");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysVersionLessThanOrEqualTo(String value) {
            addCriterion("sys_version <=", value, "sys_version");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysVersionLike(String value) {
            addCriterion("sys_version like ", value, "sys_version", 1);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysVersionNotLike(String value) {
            addCriterion("sys_version  not like ", value, "sys_version", 1);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysVersionLeftLike(String value) {
            addCriterion("sys_version like ", value, "sys_version", 0);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysVersionNotLeftLike(String value) {
            addCriterion("sys_version  not like ", value, "sys_version", 0);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysVersionRightLike(String value) {
            addCriterion("sys_version like ", value, "sys_version", 2);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysVersionNotRightLike(String value) {
            addCriterion("sys_version  not like ", value, "sys_version", 2);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysVersionIn(List<String> values) {
            addCriterion("sys_version  in ", values, "sys_version");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysVersionNotIn(List<String> values) {
            addCriterion("sys_version not in ", values, "sys_version");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysVersionBetween(String value1, String value2) {
            addCriterion("sys_version between ", value1, value2, "sys_version");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andSysVersionNotBetween(String value1, String value2) {
            addCriterion("sys_version not between ", value1, value2, "sys_version");
            return (UserBehaveCriteria) this;
        }
        public UserBehaveCriteria andAppVersionIsNull() {
            addCriterion("app_version is null");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andAppVersionIsNotNull() {
            addCriterion("app_version is not null");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andAppVersionEqualTo(String value) {
            addCriterion("app_version =", value, "app_version");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andAppVersionNotEqualTo(String value) {
            addCriterion("app_version <>", value, "app_version");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andAppVersionGreaterThan(String value) {
            addCriterion("app_version >", value, "app_version");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andAppVersionGreaterThanOrEqualTo(String value) {
            addCriterion("app_version >=", value, "app_version");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andAppVersionLessThan(String value) {
            addCriterion("app_version <", value, "app_version");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andAppVersionLessThanOrEqualTo(String value) {
            addCriterion("app_version <=", value, "app_version");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andAppVersionLike(String value) {
            addCriterion("app_version like ", value, "app_version", 1);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andAppVersionNotLike(String value) {
            addCriterion("app_version  not like ", value, "app_version", 1);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andAppVersionLeftLike(String value) {
            addCriterion("app_version like ", value, "app_version", 0);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andAppVersionNotLeftLike(String value) {
            addCriterion("app_version  not like ", value, "app_version", 0);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andAppVersionRightLike(String value) {
            addCriterion("app_version like ", value, "app_version", 2);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andAppVersionNotRightLike(String value) {
            addCriterion("app_version  not like ", value, "app_version", 2);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andAppVersionIn(List<String> values) {
            addCriterion("app_version  in ", values, "app_version");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andAppVersionNotIn(List<String> values) {
            addCriterion("app_version not in ", values, "app_version");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andAppVersionBetween(String value1, String value2) {
            addCriterion("app_version between ", value1, value2, "app_version");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andAppVersionNotBetween(String value1, String value2) {
            addCriterion("app_version not between ", value1, value2, "app_version");
            return (UserBehaveCriteria) this;
        }
        public UserBehaveCriteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "user_phone");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "user_phone");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "user_phone");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "user_phone");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "user_phone");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "user_phone");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserPhoneLike(String value) {
            addCriterion("user_phone like ", value, "user_phone", 1);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone  not like ", value, "user_phone", 1);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserPhoneLeftLike(String value) {
            addCriterion("user_phone like ", value, "user_phone", 0);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserPhoneNotLeftLike(String value) {
            addCriterion("user_phone  not like ", value, "user_phone", 0);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserPhoneRightLike(String value) {
            addCriterion("user_phone like ", value, "user_phone", 2);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserPhoneNotRightLike(String value) {
            addCriterion("user_phone  not like ", value, "user_phone", 2);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone  in ", values, "user_phone");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in ", values, "user_phone");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between ", value1, value2, "user_phone");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between ", value1, value2, "user_phone");
            return (UserBehaveCriteria) this;
        }
        public UserBehaveCriteria andModuleIsNull() {
            addCriterion("module is null");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andModuleIsNotNull() {
            addCriterion("module is not null");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andModuleEqualTo(String value) {
            addCriterion("module =", value, "module");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andModuleNotEqualTo(String value) {
            addCriterion("module <>", value, "module");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andModuleGreaterThan(String value) {
            addCriterion("module >", value, "module");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andModuleGreaterThanOrEqualTo(String value) {
            addCriterion("module >=", value, "module");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andModuleLessThan(String value) {
            addCriterion("module <", value, "module");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andModuleLessThanOrEqualTo(String value) {
            addCriterion("module <=", value, "module");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andModuleLike(String value) {
            addCriterion("module like ", value, "module", 1);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andModuleNotLike(String value) {
            addCriterion("module  not like ", value, "module", 1);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andModuleLeftLike(String value) {
            addCriterion("module like ", value, "module", 0);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andModuleNotLeftLike(String value) {
            addCriterion("module  not like ", value, "module", 0);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andModuleRightLike(String value) {
            addCriterion("module like ", value, "module", 2);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andModuleNotRightLike(String value) {
            addCriterion("module  not like ", value, "module", 2);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andModuleIn(List<String> values) {
            addCriterion("module  in ", values, "module");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andModuleNotIn(List<String> values) {
            addCriterion("module not in ", values, "module");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andModuleBetween(String value1, String value2) {
            addCriterion("module between ", value1, value2, "module");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andModuleNotBetween(String value1, String value2) {
            addCriterion("module not between ", value1, value2, "module");
            return (UserBehaveCriteria) this;
        }
        public UserBehaveCriteria andReqUrlIsNull() {
            addCriterion("req_url is null");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andReqUrlIsNotNull() {
            addCriterion("req_url is not null");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andReqUrlEqualTo(String value) {
            addCriterion("req_url =", value, "req_url");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andReqUrlNotEqualTo(String value) {
            addCriterion("req_url <>", value, "req_url");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andReqUrlGreaterThan(String value) {
            addCriterion("req_url >", value, "req_url");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andReqUrlGreaterThanOrEqualTo(String value) {
            addCriterion("req_url >=", value, "req_url");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andReqUrlLessThan(String value) {
            addCriterion("req_url <", value, "req_url");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andReqUrlLessThanOrEqualTo(String value) {
            addCriterion("req_url <=", value, "req_url");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andReqUrlLike(String value) {
            addCriterion("req_url like ", value, "req_url", 1);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andReqUrlNotLike(String value) {
            addCriterion("req_url  not like ", value, "req_url", 1);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andReqUrlLeftLike(String value) {
            addCriterion("req_url like ", value, "req_url", 0);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andReqUrlNotLeftLike(String value) {
            addCriterion("req_url  not like ", value, "req_url", 0);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andReqUrlRightLike(String value) {
            addCriterion("req_url like ", value, "req_url", 2);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andReqUrlNotRightLike(String value) {
            addCriterion("req_url  not like ", value, "req_url", 2);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andReqUrlIn(List<String> values) {
            addCriterion("req_url  in ", values, "req_url");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andReqUrlNotIn(List<String> values) {
            addCriterion("req_url not in ", values, "req_url");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andReqUrlBetween(String value1, String value2) {
            addCriterion("req_url between ", value1, value2, "req_url");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andReqUrlNotBetween(String value1, String value2) {
            addCriterion("req_url not between ", value1, value2, "req_url");
            return (UserBehaveCriteria) this;
        }
        public UserBehaveCriteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "create_date");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "create_date");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "create_date");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "create_date");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "create_date");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "create_date");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andCreateDateLike(Date value) {
            addCriterion("create_date like ", value, "create_date", 1);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andCreateDateNotLike(Date value) {
            addCriterion("create_date  not like ", value, "create_date", 1);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andCreateDateLeftLike(Date value) {
            addCriterion("create_date like ", value, "create_date", 0);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andCreateDateNotLeftLike(Date value) {
            addCriterion("create_date  not like ", value, "create_date", 0);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andCreateDateRightLike(Date value) {
            addCriterion("create_date like ", value, "create_date", 2);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andCreateDateNotRightLike(Date value) {
            addCriterion("create_date  not like ", value, "create_date", 2);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date  in ", values, "create_date");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in ", values, "create_date");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between ", value1, value2, "create_date");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between ", value1, value2, "create_date");
            return (UserBehaveCriteria) this;
        }
        public UserBehaveCriteria andStateIsNull() {
            addCriterion("state is null");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andStateLike(String value) {
            addCriterion("state like ", value, "state", 1);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andStateNotLike(String value) {
            addCriterion("state  not like ", value, "state", 1);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andStateLeftLike(String value) {
            addCriterion("state like ", value, "state", 0);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andStateNotLeftLike(String value) {
            addCriterion("state  not like ", value, "state", 0);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andStateRightLike(String value) {
            addCriterion("state like ", value, "state", 2);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andStateNotRightLike(String value) {
            addCriterion("state  not like ", value, "state", 2);
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andStateIn(List<String> values) {
            addCriterion("state  in ", values, "state");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andStateNotIn(List<String> values) {
            addCriterion("state not in ", values, "state");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andStateBetween(String value1, String value2) {
            addCriterion("state between ", value1, value2, "state");
            return (UserBehaveCriteria) this;
        }

        public UserBehaveCriteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between ", value1, value2, "state");
            return (UserBehaveCriteria) this;
        }

    }

    public static class UserBehaveCriteria extends GeneratedCriteria {

        protected UserBehaveCriteria() {
            super();
        }
    }

    public static class UserBehaveCriterion {
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

        protected UserBehaveCriterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        protected UserBehaveCriterion(String condition, Object value, int likeType) {
            this.condition = condition;
            if (likeType == 0) {
                this.value = "%" + value;
            }
            else if (likeType == 1) {
                this.value = "%" + value + "%";
            }
            else {
                this.value = value + "%";
            }
            this.typeHandler = null;
            this.singleValue = true;

        }

        protected UserBehaveCriterion(String condition, Object value,
                String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            }
            else {
                this.singleValue = true;
            }
        }

        protected UserBehaveCriterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected UserBehaveCriterion(String condition, Object value,
                Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected UserBehaveCriterion(String condition, Object value,
                Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}