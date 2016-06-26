package com.ztesoft.web.busiz.db.arg;

import java.util.*;
import java.math.*;
import org.apache.commons.lang.*;

public class SjJobArg {
    private String pk_name = "job_id";

    private String orderByClause;

    private String groupByClause;

    private String columns;

    private String countsql1;

    private String countsql2;

    private boolean distinct;

    private int rowStart = 0;

    private int rowEnd = 10;

    private List<SjJobCriteria> oredCriteria;

    public SjJobArg() {
        oredCriteria = new ArrayList<SjJobCriteria>();
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

    public List<SjJobCriteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(SjJobCriteria criteria) {
        oredCriteria.add(criteria);
    }

    public SjJobCriteria or() {
    	SjJobCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public SjJobCriteria createCriteria() {
    	SjJobCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected SjJobCriteria createCriteriaInternal() {
    	SjJobCriteria criteria = new SjJobCriteria();
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
        protected List<SjJobCriterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<SjJobCriterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<SjJobCriterion> getAllCriteria() {
            return criteria;
        }

        public List<SjJobCriterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new SjJobCriterion(condition));
        }

        protected void addCriterion(String condition, Object value,
                String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new SjJobCriterion(condition, value));
        }

        protected void addCriterion(String condition, Object value,
                String property, int likeType) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new SjJobCriterion(condition, value, likeType));
        }

        protected void addCriterion(String condition, Object value1,
                Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property
                        + " cannot be null");
            }
            criteria.add(new SjJobCriterion(condition, value1, value2));
        }

        public SjJobCriteria andCriterionEqualTo(String criterion) {
            if (StringUtils.isBlank(criterion)) {
                criterion = "1=1";
            }
            addCriterion(criterion);
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andJobIdIsNull() {
            addCriterion("job_id is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobIdIsNotNull() {
            addCriterion("job_id is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobIdEqualTo(Integer value) {
            addCriterion("job_id =", value, "job_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobIdNotEqualTo(Integer value) {
            addCriterion("job_id <>", value, "job_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobIdGreaterThan(Integer value) {
            addCriterion("job_id >", value, "job_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("job_id >=", value, "job_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobIdLessThan(Integer value) {
            addCriterion("job_id <", value, "job_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobIdLessThanOrEqualTo(Integer value) {
            addCriterion("job_id <=", value, "job_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobIdLike(Integer value) {
            addCriterion("job_id like ", value, "job_id", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobIdNotLike(Integer value) {
            addCriterion("job_id  not like ", value, "job_id", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobIdLeftLike(Integer value) {
            addCriterion("job_id like ", value, "job_id", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobIdNotLeftLike(Integer value) {
            addCriterion("job_id  not like ", value, "job_id", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobIdRightLike(Integer value) {
            addCriterion("job_id like ", value, "job_id", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobIdNotRightLike(Integer value) {
            addCriterion("job_id  not like ", value, "job_id", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobIdIn(List<Integer> values) {
            addCriterion("job_id  in ", values, "job_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobIdNotIn(List<Integer> values) {
            addCriterion("job_id not in ", values, "job_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobIdBetween(Integer value1, Integer value2) {
            addCriterion("job_id between ", value1, value2, "job_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobIdNotBetween(Integer value1, Integer value2) {
            addCriterion("job_id not between ", value1, value2, "job_id");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andJobNameIsNull() {
            addCriterion("job_name is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobNameIsNotNull() {
            addCriterion("job_name is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobNameEqualTo(String value) {
            addCriterion("job_name =", value, "job_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobNameNotEqualTo(String value) {
            addCriterion("job_name <>", value, "job_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobNameGreaterThan(String value) {
            addCriterion("job_name >", value, "job_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobNameGreaterThanOrEqualTo(String value) {
            addCriterion("job_name >=", value, "job_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobNameLessThan(String value) {
            addCriterion("job_name <", value, "job_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobNameLessThanOrEqualTo(String value) {
            addCriterion("job_name <=", value, "job_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobNameLike(String value) {
            addCriterion("job_name like ", value, "job_name", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobNameNotLike(String value) {
            addCriterion("job_name  not like ", value, "job_name", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobNameLeftLike(String value) {
            addCriterion("job_name like ", value, "job_name", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobNameNotLeftLike(String value) {
            addCriterion("job_name  not like ", value, "job_name", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobNameRightLike(String value) {
            addCriterion("job_name like ", value, "job_name", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobNameNotRightLike(String value) {
            addCriterion("job_name  not like ", value, "job_name", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobNameIn(List<String> values) {
            addCriterion("job_name  in ", values, "job_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobNameNotIn(List<String> values) {
            addCriterion("job_name not in ", values, "job_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobNameBetween(String value1, String value2) {
            addCriterion("job_name between ", value1, value2, "job_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobNameNotBetween(String value1, String value2) {
            addCriterion("job_name not between ", value1, value2, "job_name");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andCompNameIsNull() {
            addCriterion("comp_name is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompNameIsNotNull() {
            addCriterion("comp_name is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompNameEqualTo(String value) {
            addCriterion("comp_name =", value, "comp_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompNameNotEqualTo(String value) {
            addCriterion("comp_name <>", value, "comp_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompNameGreaterThan(String value) {
            addCriterion("comp_name >", value, "comp_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompNameGreaterThanOrEqualTo(String value) {
            addCriterion("comp_name >=", value, "comp_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompNameLessThan(String value) {
            addCriterion("comp_name <", value, "comp_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompNameLessThanOrEqualTo(String value) {
            addCriterion("comp_name <=", value, "comp_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompNameLike(String value) {
            addCriterion("comp_name like ", value, "comp_name", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompNameNotLike(String value) {
            addCriterion("comp_name  not like ", value, "comp_name", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompNameLeftLike(String value) {
            addCriterion("comp_name like ", value, "comp_name", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompNameNotLeftLike(String value) {
            addCriterion("comp_name  not like ", value, "comp_name", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompNameRightLike(String value) {
            addCriterion("comp_name like ", value, "comp_name", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompNameNotRightLike(String value) {
            addCriterion("comp_name  not like ", value, "comp_name", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompNameIn(List<String> values) {
            addCriterion("comp_name  in ", values, "comp_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompNameNotIn(List<String> values) {
            addCriterion("comp_name not in ", values, "comp_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompNameBetween(String value1, String value2) {
            addCriterion("comp_name between ", value1, value2, "comp_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompNameNotBetween(String value1, String value2) {
            addCriterion("comp_name not between ", value1, value2, "comp_name");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andCompIdIsNull() {
            addCriterion("comp_id is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompIdIsNotNull() {
            addCriterion("comp_id is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompIdEqualTo(String value) {
            addCriterion("comp_id =", value, "comp_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompIdNotEqualTo(String value) {
            addCriterion("comp_id <>", value, "comp_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompIdGreaterThan(String value) {
            addCriterion("comp_id >", value, "comp_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompIdGreaterThanOrEqualTo(String value) {
            addCriterion("comp_id >=", value, "comp_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompIdLessThan(String value) {
            addCriterion("comp_id <", value, "comp_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompIdLessThanOrEqualTo(String value) {
            addCriterion("comp_id <=", value, "comp_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompIdLike(String value) {
            addCriterion("comp_id like ", value, "comp_id", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompIdNotLike(String value) {
            addCriterion("comp_id  not like ", value, "comp_id", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompIdLeftLike(String value) {
            addCriterion("comp_id like ", value, "comp_id", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompIdNotLeftLike(String value) {
            addCriterion("comp_id  not like ", value, "comp_id", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompIdRightLike(String value) {
            addCriterion("comp_id like ", value, "comp_id", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompIdNotRightLike(String value) {
            addCriterion("comp_id  not like ", value, "comp_id", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompIdIn(List<String> values) {
            addCriterion("comp_id  in ", values, "comp_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompIdNotIn(List<String> values) {
            addCriterion("comp_id not in ", values, "comp_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompIdBetween(String value1, String value2) {
            addCriterion("comp_id between ", value1, value2, "comp_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompIdNotBetween(String value1, String value2) {
            addCriterion("comp_id not between ", value1, value2, "comp_id");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andCompAddrIsNull() {
            addCriterion("comp_addr is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompAddrIsNotNull() {
            addCriterion("comp_addr is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompAddrEqualTo(String value) {
            addCriterion("comp_addr =", value, "comp_addr");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompAddrNotEqualTo(String value) {
            addCriterion("comp_addr <>", value, "comp_addr");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompAddrGreaterThan(String value) {
            addCriterion("comp_addr >", value, "comp_addr");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompAddrGreaterThanOrEqualTo(String value) {
            addCriterion("comp_addr >=", value, "comp_addr");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompAddrLessThan(String value) {
            addCriterion("comp_addr <", value, "comp_addr");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompAddrLessThanOrEqualTo(String value) {
            addCriterion("comp_addr <=", value, "comp_addr");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompAddrLike(String value) {
            addCriterion("comp_addr like ", value, "comp_addr", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompAddrNotLike(String value) {
            addCriterion("comp_addr  not like ", value, "comp_addr", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompAddrLeftLike(String value) {
            addCriterion("comp_addr like ", value, "comp_addr", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompAddrNotLeftLike(String value) {
            addCriterion("comp_addr  not like ", value, "comp_addr", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompAddrRightLike(String value) {
            addCriterion("comp_addr like ", value, "comp_addr", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompAddrNotRightLike(String value) {
            addCriterion("comp_addr  not like ", value, "comp_addr", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompAddrIn(List<String> values) {
            addCriterion("comp_addr  in ", values, "comp_addr");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompAddrNotIn(List<String> values) {
            addCriterion("comp_addr not in ", values, "comp_addr");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompAddrBetween(String value1, String value2) {
            addCriterion("comp_addr between ", value1, value2, "comp_addr");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompAddrNotBetween(String value1, String value2) {
            addCriterion("comp_addr not between ", value1, value2, "comp_addr");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andCompDescIsNull() {
            addCriterion("comp_desc is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompDescIsNotNull() {
            addCriterion("comp_desc is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompDescEqualTo(String value) {
            addCriterion("comp_desc =", value, "comp_desc");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompDescNotEqualTo(String value) {
            addCriterion("comp_desc <>", value, "comp_desc");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompDescGreaterThan(String value) {
            addCriterion("comp_desc >", value, "comp_desc");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompDescGreaterThanOrEqualTo(String value) {
            addCriterion("comp_desc >=", value, "comp_desc");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompDescLessThan(String value) {
            addCriterion("comp_desc <", value, "comp_desc");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompDescLessThanOrEqualTo(String value) {
            addCriterion("comp_desc <=", value, "comp_desc");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompDescLike(String value) {
            addCriterion("comp_desc like ", value, "comp_desc", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompDescNotLike(String value) {
            addCriterion("comp_desc  not like ", value, "comp_desc", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompDescLeftLike(String value) {
            addCriterion("comp_desc like ", value, "comp_desc", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompDescNotLeftLike(String value) {
            addCriterion("comp_desc  not like ", value, "comp_desc", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompDescRightLike(String value) {
            addCriterion("comp_desc like ", value, "comp_desc", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompDescNotRightLike(String value) {
            addCriterion("comp_desc  not like ", value, "comp_desc", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompDescIn(List<String> values) {
            addCriterion("comp_desc  in ", values, "comp_desc");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompDescNotIn(List<String> values) {
            addCriterion("comp_desc not in ", values, "comp_desc");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompDescBetween(String value1, String value2) {
            addCriterion("comp_desc between ", value1, value2, "comp_desc");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompDescNotBetween(String value1, String value2) {
            addCriterion("comp_desc not between ", value1, value2, "comp_desc");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andCompEmailIsNull() {
            addCriterion("comp_email is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompEmailIsNotNull() {
            addCriterion("comp_email is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompEmailEqualTo(String value) {
            addCriterion("comp_email =", value, "comp_email");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompEmailNotEqualTo(String value) {
            addCriterion("comp_email <>", value, "comp_email");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompEmailGreaterThan(String value) {
            addCriterion("comp_email >", value, "comp_email");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompEmailGreaterThanOrEqualTo(String value) {
            addCriterion("comp_email >=", value, "comp_email");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompEmailLessThan(String value) {
            addCriterion("comp_email <", value, "comp_email");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompEmailLessThanOrEqualTo(String value) {
            addCriterion("comp_email <=", value, "comp_email");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompEmailLike(String value) {
            addCriterion("comp_email like ", value, "comp_email", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompEmailNotLike(String value) {
            addCriterion("comp_email  not like ", value, "comp_email", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompEmailLeftLike(String value) {
            addCriterion("comp_email like ", value, "comp_email", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompEmailNotLeftLike(String value) {
            addCriterion("comp_email  not like ", value, "comp_email", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompEmailRightLike(String value) {
            addCriterion("comp_email like ", value, "comp_email", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompEmailNotRightLike(String value) {
            addCriterion("comp_email  not like ", value, "comp_email", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompEmailIn(List<String> values) {
            addCriterion("comp_email  in ", values, "comp_email");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompEmailNotIn(List<String> values) {
            addCriterion("comp_email not in ", values, "comp_email");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompEmailBetween(String value1, String value2) {
            addCriterion("comp_email between ", value1, value2, "comp_email");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompEmailNotBetween(String value1, String value2) {
            addCriterion("comp_email not between ", value1, value2, "comp_email");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andCompTypeIsNull() {
            addCriterion("comp_type is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompTypeIsNotNull() {
            addCriterion("comp_type is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompTypeEqualTo(String value) {
            addCriterion("comp_type =", value, "comp_type");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompTypeNotEqualTo(String value) {
            addCriterion("comp_type <>", value, "comp_type");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompTypeGreaterThan(String value) {
            addCriterion("comp_type >", value, "comp_type");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompTypeGreaterThanOrEqualTo(String value) {
            addCriterion("comp_type >=", value, "comp_type");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompTypeLessThan(String value) {
            addCriterion("comp_type <", value, "comp_type");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompTypeLessThanOrEqualTo(String value) {
            addCriterion("comp_type <=", value, "comp_type");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompTypeLike(String value) {
            addCriterion("comp_type like ", value, "comp_type", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompTypeNotLike(String value) {
            addCriterion("comp_type  not like ", value, "comp_type", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompTypeLeftLike(String value) {
            addCriterion("comp_type like ", value, "comp_type", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompTypeNotLeftLike(String value) {
            addCriterion("comp_type  not like ", value, "comp_type", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompTypeRightLike(String value) {
            addCriterion("comp_type like ", value, "comp_type", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompTypeNotRightLike(String value) {
            addCriterion("comp_type  not like ", value, "comp_type", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompTypeIn(List<String> values) {
            addCriterion("comp_type  in ", values, "comp_type");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompTypeNotIn(List<String> values) {
            addCriterion("comp_type not in ", values, "comp_type");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompTypeBetween(String value1, String value2) {
            addCriterion("comp_type between ", value1, value2, "comp_type");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompTypeNotBetween(String value1, String value2) {
            addCriterion("comp_type not between ", value1, value2, "comp_type");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andCompScaleIsNull() {
            addCriterion("comp_scale is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleIsNotNull() {
            addCriterion("comp_scale is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleEqualTo(String value) {
            addCriterion("comp_scale =", value, "comp_scale");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleNotEqualTo(String value) {
            addCriterion("comp_scale <>", value, "comp_scale");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleGreaterThan(String value) {
            addCriterion("comp_scale >", value, "comp_scale");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleGreaterThanOrEqualTo(String value) {
            addCriterion("comp_scale >=", value, "comp_scale");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleLessThan(String value) {
            addCriterion("comp_scale <", value, "comp_scale");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleLessThanOrEqualTo(String value) {
            addCriterion("comp_scale <=", value, "comp_scale");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleLike(String value) {
            addCriterion("comp_scale like ", value, "comp_scale", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleNotLike(String value) {
            addCriterion("comp_scale  not like ", value, "comp_scale", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleLeftLike(String value) {
            addCriterion("comp_scale like ", value, "comp_scale", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleNotLeftLike(String value) {
            addCriterion("comp_scale  not like ", value, "comp_scale", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleRightLike(String value) {
            addCriterion("comp_scale like ", value, "comp_scale", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleNotRightLike(String value) {
            addCriterion("comp_scale  not like ", value, "comp_scale", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleIn(List<String> values) {
            addCriterion("comp_scale  in ", values, "comp_scale");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleNotIn(List<String> values) {
            addCriterion("comp_scale not in ", values, "comp_scale");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleBetween(String value1, String value2) {
            addCriterion("comp_scale between ", value1, value2, "comp_scale");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleNotBetween(String value1, String value2) {
            addCriterion("comp_scale not between ", value1, value2, "comp_scale");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andCompScaleMinIsNull() {
            addCriterion("comp_scale_min is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMinIsNotNull() {
            addCriterion("comp_scale_min is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMinEqualTo(Integer value) {
            addCriterion("comp_scale_min =", value, "comp_scale_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMinNotEqualTo(Integer value) {
            addCriterion("comp_scale_min <>", value, "comp_scale_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMinGreaterThan(Integer value) {
            addCriterion("comp_scale_min >", value, "comp_scale_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMinGreaterThanOrEqualTo(Integer value) {
            addCriterion("comp_scale_min >=", value, "comp_scale_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMinLessThan(Integer value) {
            addCriterion("comp_scale_min <", value, "comp_scale_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMinLessThanOrEqualTo(Integer value) {
            addCriterion("comp_scale_min <=", value, "comp_scale_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMinLike(Integer value) {
            addCriterion("comp_scale_min like ", value, "comp_scale_min", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMinNotLike(Integer value) {
            addCriterion("comp_scale_min  not like ", value, "comp_scale_min", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMinLeftLike(Integer value) {
            addCriterion("comp_scale_min like ", value, "comp_scale_min", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMinNotLeftLike(Integer value) {
            addCriterion("comp_scale_min  not like ", value, "comp_scale_min", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMinRightLike(Integer value) {
            addCriterion("comp_scale_min like ", value, "comp_scale_min", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMinNotRightLike(Integer value) {
            addCriterion("comp_scale_min  not like ", value, "comp_scale_min", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMinIn(List<Integer> values) {
            addCriterion("comp_scale_min  in ", values, "comp_scale_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMinNotIn(List<Integer> values) {
            addCriterion("comp_scale_min not in ", values, "comp_scale_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMinBetween(Integer value1, Integer value2) {
            addCriterion("comp_scale_min between ", value1, value2, "comp_scale_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMinNotBetween(Integer value1, Integer value2) {
            addCriterion("comp_scale_min not between ", value1, value2, "comp_scale_min");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andCompScaleMaxIsNull() {
            addCriterion("comp_scale_max is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMaxIsNotNull() {
            addCriterion("comp_scale_max is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMaxEqualTo(Integer value) {
            addCriterion("comp_scale_max =", value, "comp_scale_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMaxNotEqualTo(Integer value) {
            addCriterion("comp_scale_max <>", value, "comp_scale_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMaxGreaterThan(Integer value) {
            addCriterion("comp_scale_max >", value, "comp_scale_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("comp_scale_max >=", value, "comp_scale_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMaxLessThan(Integer value) {
            addCriterion("comp_scale_max <", value, "comp_scale_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMaxLessThanOrEqualTo(Integer value) {
            addCriterion("comp_scale_max <=", value, "comp_scale_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMaxLike(Integer value) {
            addCriterion("comp_scale_max like ", value, "comp_scale_max", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMaxNotLike(Integer value) {
            addCriterion("comp_scale_max  not like ", value, "comp_scale_max", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMaxLeftLike(Integer value) {
            addCriterion("comp_scale_max like ", value, "comp_scale_max", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMaxNotLeftLike(Integer value) {
            addCriterion("comp_scale_max  not like ", value, "comp_scale_max", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMaxRightLike(Integer value) {
            addCriterion("comp_scale_max like ", value, "comp_scale_max", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMaxNotRightLike(Integer value) {
            addCriterion("comp_scale_max  not like ", value, "comp_scale_max", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMaxIn(List<Integer> values) {
            addCriterion("comp_scale_max  in ", values, "comp_scale_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMaxNotIn(List<Integer> values) {
            addCriterion("comp_scale_max not in ", values, "comp_scale_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMaxBetween(Integer value1, Integer value2) {
            addCriterion("comp_scale_max between ", value1, value2, "comp_scale_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCompScaleMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("comp_scale_max not between ", value1, value2, "comp_scale_max");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andSalaryRangeIsNull() {
            addCriterion("salary_range is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryRangeIsNotNull() {
            addCriterion("salary_range is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryRangeEqualTo(String value) {
            addCriterion("salary_range =", value, "salary_range");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryRangeNotEqualTo(String value) {
            addCriterion("salary_range <>", value, "salary_range");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryRangeGreaterThan(String value) {
            addCriterion("salary_range >", value, "salary_range");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryRangeGreaterThanOrEqualTo(String value) {
            addCriterion("salary_range >=", value, "salary_range");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryRangeLessThan(String value) {
            addCriterion("salary_range <", value, "salary_range");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryRangeLessThanOrEqualTo(String value) {
            addCriterion("salary_range <=", value, "salary_range");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryRangeLike(String value) {
            addCriterion("salary_range like ", value, "salary_range", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryRangeNotLike(String value) {
            addCriterion("salary_range  not like ", value, "salary_range", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryRangeLeftLike(String value) {
            addCriterion("salary_range like ", value, "salary_range", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryRangeNotLeftLike(String value) {
            addCriterion("salary_range  not like ", value, "salary_range", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryRangeRightLike(String value) {
            addCriterion("salary_range like ", value, "salary_range", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryRangeNotRightLike(String value) {
            addCriterion("salary_range  not like ", value, "salary_range", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryRangeIn(List<String> values) {
            addCriterion("salary_range  in ", values, "salary_range");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryRangeNotIn(List<String> values) {
            addCriterion("salary_range not in ", values, "salary_range");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryRangeBetween(String value1, String value2) {
            addCriterion("salary_range between ", value1, value2, "salary_range");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryRangeNotBetween(String value1, String value2) {
            addCriterion("salary_range not between ", value1, value2, "salary_range");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andSalaryMinIsNull() {
            addCriterion("salary_min is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMinIsNotNull() {
            addCriterion("salary_min is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMinEqualTo(Integer value) {
            addCriterion("salary_min =", value, "salary_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMinNotEqualTo(Integer value) {
            addCriterion("salary_min <>", value, "salary_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMinGreaterThan(Integer value) {
            addCriterion("salary_min >", value, "salary_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMinGreaterThanOrEqualTo(Integer value) {
            addCriterion("salary_min >=", value, "salary_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMinLessThan(Integer value) {
            addCriterion("salary_min <", value, "salary_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMinLessThanOrEqualTo(Integer value) {
            addCriterion("salary_min <=", value, "salary_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMinLike(Integer value) {
            addCriterion("salary_min like ", value, "salary_min", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMinNotLike(Integer value) {
            addCriterion("salary_min  not like ", value, "salary_min", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMinLeftLike(Integer value) {
            addCriterion("salary_min like ", value, "salary_min", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMinNotLeftLike(Integer value) {
            addCriterion("salary_min  not like ", value, "salary_min", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMinRightLike(Integer value) {
            addCriterion("salary_min like ", value, "salary_min", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMinNotRightLike(Integer value) {
            addCriterion("salary_min  not like ", value, "salary_min", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMinIn(List<Integer> values) {
            addCriterion("salary_min  in ", values, "salary_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMinNotIn(List<Integer> values) {
            addCriterion("salary_min not in ", values, "salary_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMinBetween(Integer value1, Integer value2) {
            addCriterion("salary_min between ", value1, value2, "salary_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMinNotBetween(Integer value1, Integer value2) {
            addCriterion("salary_min not between ", value1, value2, "salary_min");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andSalaryMaxIsNull() {
            addCriterion("salary_max is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMaxIsNotNull() {
            addCriterion("salary_max is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMaxEqualTo(Integer value) {
            addCriterion("salary_max =", value, "salary_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMaxNotEqualTo(Integer value) {
            addCriterion("salary_max <>", value, "salary_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMaxGreaterThan(Integer value) {
            addCriterion("salary_max >", value, "salary_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("salary_max >=", value, "salary_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMaxLessThan(Integer value) {
            addCriterion("salary_max <", value, "salary_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMaxLessThanOrEqualTo(Integer value) {
            addCriterion("salary_max <=", value, "salary_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMaxLike(Integer value) {
            addCriterion("salary_max like ", value, "salary_max", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMaxNotLike(Integer value) {
            addCriterion("salary_max  not like ", value, "salary_max", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMaxLeftLike(Integer value) {
            addCriterion("salary_max like ", value, "salary_max", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMaxNotLeftLike(Integer value) {
            addCriterion("salary_max  not like ", value, "salary_max", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMaxRightLike(Integer value) {
            addCriterion("salary_max like ", value, "salary_max", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMaxNotRightLike(Integer value) {
            addCriterion("salary_max  not like ", value, "salary_max", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMaxIn(List<Integer> values) {
            addCriterion("salary_max  in ", values, "salary_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMaxNotIn(List<Integer> values) {
            addCriterion("salary_max not in ", values, "salary_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMaxBetween(Integer value1, Integer value2) {
            addCriterion("salary_max between ", value1, value2, "salary_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSalaryMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("salary_max not between ", value1, value2, "salary_max");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andProvinceIsNull() {
            addCriterion("province is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andProvinceLike(String value) {
            addCriterion("province like ", value, "province", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andProvinceNotLike(String value) {
            addCriterion("province  not like ", value, "province", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andProvinceLeftLike(String value) {
            addCriterion("province like ", value, "province", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andProvinceNotLeftLike(String value) {
            addCriterion("province  not like ", value, "province", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andProvinceRightLike(String value) {
            addCriterion("province like ", value, "province", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andProvinceNotRightLike(String value) {
            addCriterion("province  not like ", value, "province", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andProvinceIn(List<String> values) {
            addCriterion("province  in ", values, "province");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in ", values, "province");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between ", value1, value2, "province");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between ", value1, value2, "province");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andCityIsNull() {
            addCriterion("city is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCityLike(String value) {
            addCriterion("city like ", value, "city", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCityNotLike(String value) {
            addCriterion("city  not like ", value, "city", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCityLeftLike(String value) {
            addCriterion("city like ", value, "city", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCityNotLeftLike(String value) {
            addCriterion("city  not like ", value, "city", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCityRightLike(String value) {
            addCriterion("city like ", value, "city", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCityNotRightLike(String value) {
            addCriterion("city  not like ", value, "city", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCityIn(List<String> values) {
            addCriterion("city  in ", values, "city");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCityNotIn(List<String> values) {
            addCriterion("city not in ", values, "city");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCityBetween(String value1, String value2) {
            addCriterion("city between ", value1, value2, "city");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between ", value1, value2, "city");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andDistrictIsNull() {
            addCriterion("district is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDistrictIsNotNull() {
            addCriterion("district is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDistrictEqualTo(String value) {
            addCriterion("district =", value, "district");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDistrictNotEqualTo(String value) {
            addCriterion("district <>", value, "district");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDistrictGreaterThan(String value) {
            addCriterion("district >", value, "district");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("district >=", value, "district");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDistrictLessThan(String value) {
            addCriterion("district <", value, "district");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDistrictLessThanOrEqualTo(String value) {
            addCriterion("district <=", value, "district");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDistrictLike(String value) {
            addCriterion("district like ", value, "district", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDistrictNotLike(String value) {
            addCriterion("district  not like ", value, "district", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDistrictLeftLike(String value) {
            addCriterion("district like ", value, "district", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDistrictNotLeftLike(String value) {
            addCriterion("district  not like ", value, "district", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDistrictRightLike(String value) {
            addCriterion("district like ", value, "district", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDistrictNotRightLike(String value) {
            addCriterion("district  not like ", value, "district", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDistrictIn(List<String> values) {
            addCriterion("district  in ", values, "district");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDistrictNotIn(List<String> values) {
            addCriterion("district not in ", values, "district");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDistrictBetween(String value1, String value2) {
            addCriterion("district between ", value1, value2, "district");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDistrictNotBetween(String value1, String value2) {
            addCriterion("district not between ", value1, value2, "district");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andLocationIsNull() {
            addCriterion("location is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andLocationLike(String value) {
            addCriterion("location like ", value, "location", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andLocationNotLike(String value) {
            addCriterion("location  not like ", value, "location", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andLocationLeftLike(String value) {
            addCriterion("location like ", value, "location", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andLocationNotLeftLike(String value) {
            addCriterion("location  not like ", value, "location", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andLocationRightLike(String value) {
            addCriterion("location like ", value, "location", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andLocationNotRightLike(String value) {
            addCriterion("location  not like ", value, "location", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andLocationIn(List<String> values) {
            addCriterion("location  in ", values, "location");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andLocationNotIn(List<String> values) {
            addCriterion("location not in ", values, "location");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andLocationBetween(String value1, String value2) {
            addCriterion("location between ", value1, value2, "location");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between ", value1, value2, "location");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andJobDescIsNull() {
            addCriterion("job_desc is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobDescIsNotNull() {
            addCriterion("job_desc is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobDescEqualTo(String value) {
            addCriterion("job_desc =", value, "job_desc");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobDescNotEqualTo(String value) {
            addCriterion("job_desc <>", value, "job_desc");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobDescGreaterThan(String value) {
            addCriterion("job_desc >", value, "job_desc");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobDescGreaterThanOrEqualTo(String value) {
            addCriterion("job_desc >=", value, "job_desc");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobDescLessThan(String value) {
            addCriterion("job_desc <", value, "job_desc");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobDescLessThanOrEqualTo(String value) {
            addCriterion("job_desc <=", value, "job_desc");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobDescLike(String value) {
            addCriterion("job_desc like ", value, "job_desc", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobDescNotLike(String value) {
            addCriterion("job_desc  not like ", value, "job_desc", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobDescLeftLike(String value) {
            addCriterion("job_desc like ", value, "job_desc", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobDescNotLeftLike(String value) {
            addCriterion("job_desc  not like ", value, "job_desc", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobDescRightLike(String value) {
            addCriterion("job_desc like ", value, "job_desc", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobDescNotRightLike(String value) {
            addCriterion("job_desc  not like ", value, "job_desc", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobDescIn(List<String> values) {
            addCriterion("job_desc  in ", values, "job_desc");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobDescNotIn(List<String> values) {
            addCriterion("job_desc not in ", values, "job_desc");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobDescBetween(String value1, String value2) {
            addCriterion("job_desc between ", value1, value2, "job_desc");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobDescNotBetween(String value1, String value2) {
            addCriterion("job_desc not between ", value1, value2, "job_desc");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andJobTypeIsNull() {
            addCriterion("job_type is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobTypeIsNotNull() {
            addCriterion("job_type is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobTypeEqualTo(String value) {
            addCriterion("job_type =", value, "job_type");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobTypeNotEqualTo(String value) {
            addCriterion("job_type <>", value, "job_type");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobTypeGreaterThan(String value) {
            addCriterion("job_type >", value, "job_type");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobTypeGreaterThanOrEqualTo(String value) {
            addCriterion("job_type >=", value, "job_type");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobTypeLessThan(String value) {
            addCriterion("job_type <", value, "job_type");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobTypeLessThanOrEqualTo(String value) {
            addCriterion("job_type <=", value, "job_type");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobTypeLike(String value) {
            addCriterion("job_type like ", value, "job_type", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobTypeNotLike(String value) {
            addCriterion("job_type  not like ", value, "job_type", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobTypeLeftLike(String value) {
            addCriterion("job_type like ", value, "job_type", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobTypeNotLeftLike(String value) {
            addCriterion("job_type  not like ", value, "job_type", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobTypeRightLike(String value) {
            addCriterion("job_type like ", value, "job_type", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobTypeNotRightLike(String value) {
            addCriterion("job_type  not like ", value, "job_type", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobTypeIn(List<String> values) {
            addCriterion("job_type  in ", values, "job_type");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobTypeNotIn(List<String> values) {
            addCriterion("job_type not in ", values, "job_type");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobTypeBetween(String value1, String value2) {
            addCriterion("job_type between ", value1, value2, "job_type");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobTypeNotBetween(String value1, String value2) {
            addCriterion("job_type not between ", value1, value2, "job_type");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andEducationIsNull() {
            addCriterion("education is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEducationIsNotNull() {
            addCriterion("education is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEducationEqualTo(String value) {
            addCriterion("education =", value, "education");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEducationNotEqualTo(String value) {
            addCriterion("education <>", value, "education");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEducationGreaterThan(String value) {
            addCriterion("education >", value, "education");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEducationGreaterThanOrEqualTo(String value) {
            addCriterion("education >=", value, "education");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEducationLessThan(String value) {
            addCriterion("education <", value, "education");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEducationLessThanOrEqualTo(String value) {
            addCriterion("education <=", value, "education");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEducationLike(String value) {
            addCriterion("education like ", value, "education", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEducationNotLike(String value) {
            addCriterion("education  not like ", value, "education", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEducationLeftLike(String value) {
            addCriterion("education like ", value, "education", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEducationNotLeftLike(String value) {
            addCriterion("education  not like ", value, "education", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEducationRightLike(String value) {
            addCriterion("education like ", value, "education", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEducationNotRightLike(String value) {
            addCriterion("education  not like ", value, "education", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEducationIn(List<String> values) {
            addCriterion("education  in ", values, "education");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEducationNotIn(List<String> values) {
            addCriterion("education not in ", values, "education");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEducationBetween(String value1, String value2) {
            addCriterion("education between ", value1, value2, "education");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEducationNotBetween(String value1, String value2) {
            addCriterion("education not between ", value1, value2, "education");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andSexIsNull() {
            addCriterion("sex is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSexLike(String value) {
            addCriterion("sex like ", value, "sex", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSexNotLike(String value) {
            addCriterion("sex  not like ", value, "sex", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSexLeftLike(String value) {
            addCriterion("sex like ", value, "sex", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSexNotLeftLike(String value) {
            addCriterion("sex  not like ", value, "sex", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSexRightLike(String value) {
            addCriterion("sex like ", value, "sex", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSexNotRightLike(String value) {
            addCriterion("sex  not like ", value, "sex", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSexIn(List<String> values) {
            addCriterion("sex  in ", values, "sex");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSexNotIn(List<String> values) {
            addCriterion("sex not in ", values, "sex");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSexBetween(String value1, String value2) {
            addCriterion("sex between ", value1, value2, "sex");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between ", value1, value2, "sex");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andNumberIsNull() {
            addCriterion("number is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andNumberEqualTo(String value) {
            addCriterion("number =", value, "number");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andNumberNotEqualTo(String value) {
            addCriterion("number <>", value, "number");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andNumberGreaterThan(String value) {
            addCriterion("number >", value, "number");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("number >=", value, "number");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andNumberLessThan(String value) {
            addCriterion("number <", value, "number");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("number <=", value, "number");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andNumberLike(String value) {
            addCriterion("number like ", value, "number", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andNumberNotLike(String value) {
            addCriterion("number  not like ", value, "number", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andNumberLeftLike(String value) {
            addCriterion("number like ", value, "number", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andNumberNotLeftLike(String value) {
            addCriterion("number  not like ", value, "number", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andNumberRightLike(String value) {
            addCriterion("number like ", value, "number", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andNumberNotRightLike(String value) {
            addCriterion("number  not like ", value, "number", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andNumberIn(List<String> values) {
            addCriterion("number  in ", values, "number");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andNumberNotIn(List<String> values) {
            addCriterion("number not in ", values, "number");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andNumberBetween(String value1, String value2) {
            addCriterion("number between ", value1, value2, "number");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andNumberNotBetween(String value1, String value2) {
            addCriterion("number not between ", value1, value2, "number");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andExperienceIsNull() {
            addCriterion("experience is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExperienceIsNotNull() {
            addCriterion("experience is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExperienceEqualTo(String value) {
            addCriterion("experience =", value, "experience");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExperienceNotEqualTo(String value) {
            addCriterion("experience <>", value, "experience");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExperienceGreaterThan(String value) {
            addCriterion("experience >", value, "experience");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExperienceGreaterThanOrEqualTo(String value) {
            addCriterion("experience >=", value, "experience");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExperienceLessThan(String value) {
            addCriterion("experience <", value, "experience");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExperienceLessThanOrEqualTo(String value) {
            addCriterion("experience <=", value, "experience");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExperienceLike(String value) {
            addCriterion("experience like ", value, "experience", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExperienceNotLike(String value) {
            addCriterion("experience  not like ", value, "experience", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExperienceLeftLike(String value) {
            addCriterion("experience like ", value, "experience", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExperienceNotLeftLike(String value) {
            addCriterion("experience  not like ", value, "experience", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExperienceRightLike(String value) {
            addCriterion("experience like ", value, "experience", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExperienceNotRightLike(String value) {
            addCriterion("experience  not like ", value, "experience", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExperienceIn(List<String> values) {
            addCriterion("experience  in ", values, "experience");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExperienceNotIn(List<String> values) {
            addCriterion("experience not in ", values, "experience");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExperienceBetween(String value1, String value2) {
            addCriterion("experience between ", value1, value2, "experience");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExperienceNotBetween(String value1, String value2) {
            addCriterion("experience not between ", value1, value2, "experience");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andExpMinIsNull() {
            addCriterion("exp_min is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMinIsNotNull() {
            addCriterion("exp_min is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMinEqualTo(Integer value) {
            addCriterion("exp_min =", value, "exp_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMinNotEqualTo(Integer value) {
            addCriterion("exp_min <>", value, "exp_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMinGreaterThan(Integer value) {
            addCriterion("exp_min >", value, "exp_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMinGreaterThanOrEqualTo(Integer value) {
            addCriterion("exp_min >=", value, "exp_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMinLessThan(Integer value) {
            addCriterion("exp_min <", value, "exp_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMinLessThanOrEqualTo(Integer value) {
            addCriterion("exp_min <=", value, "exp_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMinLike(Integer value) {
            addCriterion("exp_min like ", value, "exp_min", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMinNotLike(Integer value) {
            addCriterion("exp_min  not like ", value, "exp_min", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMinLeftLike(Integer value) {
            addCriterion("exp_min like ", value, "exp_min", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMinNotLeftLike(Integer value) {
            addCriterion("exp_min  not like ", value, "exp_min", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMinRightLike(Integer value) {
            addCriterion("exp_min like ", value, "exp_min", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMinNotRightLike(Integer value) {
            addCriterion("exp_min  not like ", value, "exp_min", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMinIn(List<Integer> values) {
            addCriterion("exp_min  in ", values, "exp_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMinNotIn(List<Integer> values) {
            addCriterion("exp_min not in ", values, "exp_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMinBetween(Integer value1, Integer value2) {
            addCriterion("exp_min between ", value1, value2, "exp_min");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMinNotBetween(Integer value1, Integer value2) {
            addCriterion("exp_min not between ", value1, value2, "exp_min");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andExpMaxIsNull() {
            addCriterion("exp_max is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMaxIsNotNull() {
            addCriterion("exp_max is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMaxEqualTo(Integer value) {
            addCriterion("exp_max =", value, "exp_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMaxNotEqualTo(Integer value) {
            addCriterion("exp_max <>", value, "exp_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMaxGreaterThan(Integer value) {
            addCriterion("exp_max >", value, "exp_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("exp_max >=", value, "exp_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMaxLessThan(Integer value) {
            addCriterion("exp_max <", value, "exp_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMaxLessThanOrEqualTo(Integer value) {
            addCriterion("exp_max <=", value, "exp_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMaxLike(Integer value) {
            addCriterion("exp_max like ", value, "exp_max", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMaxNotLike(Integer value) {
            addCriterion("exp_max  not like ", value, "exp_max", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMaxLeftLike(Integer value) {
            addCriterion("exp_max like ", value, "exp_max", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMaxNotLeftLike(Integer value) {
            addCriterion("exp_max  not like ", value, "exp_max", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMaxRightLike(Integer value) {
            addCriterion("exp_max like ", value, "exp_max", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMaxNotRightLike(Integer value) {
            addCriterion("exp_max  not like ", value, "exp_max", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMaxIn(List<Integer> values) {
            addCriterion("exp_max  in ", values, "exp_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMaxNotIn(List<Integer> values) {
            addCriterion("exp_max not in ", values, "exp_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMaxBetween(Integer value1, Integer value2) {
            addCriterion("exp_max between ", value1, value2, "exp_max");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andExpMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("exp_max not between ", value1, value2, "exp_max");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andJobFirstClassIsNull() {
            addCriterion("job_first_class is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFirstClassIsNotNull() {
            addCriterion("job_first_class is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFirstClassEqualTo(String value) {
            addCriterion("job_first_class =", value, "job_first_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFirstClassNotEqualTo(String value) {
            addCriterion("job_first_class <>", value, "job_first_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFirstClassGreaterThan(String value) {
            addCriterion("job_first_class >", value, "job_first_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFirstClassGreaterThanOrEqualTo(String value) {
            addCriterion("job_first_class >=", value, "job_first_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFirstClassLessThan(String value) {
            addCriterion("job_first_class <", value, "job_first_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFirstClassLessThanOrEqualTo(String value) {
            addCriterion("job_first_class <=", value, "job_first_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFirstClassLike(String value) {
            addCriterion("job_first_class like ", value, "job_first_class", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFirstClassNotLike(String value) {
            addCriterion("job_first_class  not like ", value, "job_first_class", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFirstClassLeftLike(String value) {
            addCriterion("job_first_class like ", value, "job_first_class", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFirstClassNotLeftLike(String value) {
            addCriterion("job_first_class  not like ", value, "job_first_class", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFirstClassRightLike(String value) {
            addCriterion("job_first_class like ", value, "job_first_class", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFirstClassNotRightLike(String value) {
            addCriterion("job_first_class  not like ", value, "job_first_class", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFirstClassIn(List<String> values) {
            addCriterion("job_first_class  in ", values, "job_first_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFirstClassNotIn(List<String> values) {
            addCriterion("job_first_class not in ", values, "job_first_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFirstClassBetween(String value1, String value2) {
            addCriterion("job_first_class between ", value1, value2, "job_first_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFirstClassNotBetween(String value1, String value2) {
            addCriterion("job_first_class not between ", value1, value2, "job_first_class");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andJobSecondClassIsNull() {
            addCriterion("job_second_class is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobSecondClassIsNotNull() {
            addCriterion("job_second_class is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobSecondClassEqualTo(String value) {
            addCriterion("job_second_class =", value, "job_second_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobSecondClassNotEqualTo(String value) {
            addCriterion("job_second_class <>", value, "job_second_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobSecondClassGreaterThan(String value) {
            addCriterion("job_second_class >", value, "job_second_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobSecondClassGreaterThanOrEqualTo(String value) {
            addCriterion("job_second_class >=", value, "job_second_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobSecondClassLessThan(String value) {
            addCriterion("job_second_class <", value, "job_second_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobSecondClassLessThanOrEqualTo(String value) {
            addCriterion("job_second_class <=", value, "job_second_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobSecondClassLike(String value) {
            addCriterion("job_second_class like ", value, "job_second_class", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobSecondClassNotLike(String value) {
            addCriterion("job_second_class  not like ", value, "job_second_class", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobSecondClassLeftLike(String value) {
            addCriterion("job_second_class like ", value, "job_second_class", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobSecondClassNotLeftLike(String value) {
            addCriterion("job_second_class  not like ", value, "job_second_class", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobSecondClassRightLike(String value) {
            addCriterion("job_second_class like ", value, "job_second_class", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobSecondClassNotRightLike(String value) {
            addCriterion("job_second_class  not like ", value, "job_second_class", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobSecondClassIn(List<String> values) {
            addCriterion("job_second_class  in ", values, "job_second_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobSecondClassNotIn(List<String> values) {
            addCriterion("job_second_class not in ", values, "job_second_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobSecondClassBetween(String value1, String value2) {
            addCriterion("job_second_class between ", value1, value2, "job_second_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobSecondClassNotBetween(String value1, String value2) {
            addCriterion("job_second_class not between ", value1, value2, "job_second_class");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andJobThirdClassIsNull() {
            addCriterion("job_third_class is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobThirdClassIsNotNull() {
            addCriterion("job_third_class is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobThirdClassEqualTo(String value) {
            addCriterion("job_third_class =", value, "job_third_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobThirdClassNotEqualTo(String value) {
            addCriterion("job_third_class <>", value, "job_third_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobThirdClassGreaterThan(String value) {
            addCriterion("job_third_class >", value, "job_third_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobThirdClassGreaterThanOrEqualTo(String value) {
            addCriterion("job_third_class >=", value, "job_third_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobThirdClassLessThan(String value) {
            addCriterion("job_third_class <", value, "job_third_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobThirdClassLessThanOrEqualTo(String value) {
            addCriterion("job_third_class <=", value, "job_third_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobThirdClassLike(String value) {
            addCriterion("job_third_class like ", value, "job_third_class", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobThirdClassNotLike(String value) {
            addCriterion("job_third_class  not like ", value, "job_third_class", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobThirdClassLeftLike(String value) {
            addCriterion("job_third_class like ", value, "job_third_class", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobThirdClassNotLeftLike(String value) {
            addCriterion("job_third_class  not like ", value, "job_third_class", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobThirdClassRightLike(String value) {
            addCriterion("job_third_class like ", value, "job_third_class", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobThirdClassNotRightLike(String value) {
            addCriterion("job_third_class  not like ", value, "job_third_class", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobThirdClassIn(List<String> values) {
            addCriterion("job_third_class  in ", values, "job_third_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobThirdClassNotIn(List<String> values) {
            addCriterion("job_third_class not in ", values, "job_third_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobThirdClassBetween(String value1, String value2) {
            addCriterion("job_third_class between ", value1, value2, "job_third_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobThirdClassNotBetween(String value1, String value2) {
            addCriterion("job_third_class not between ", value1, value2, "job_third_class");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andJobFourthClassIsNull() {
            addCriterion("job_fourth_class is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFourthClassIsNotNull() {
            addCriterion("job_fourth_class is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFourthClassEqualTo(String value) {
            addCriterion("job_fourth_class =", value, "job_fourth_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFourthClassNotEqualTo(String value) {
            addCriterion("job_fourth_class <>", value, "job_fourth_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFourthClassGreaterThan(String value) {
            addCriterion("job_fourth_class >", value, "job_fourth_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFourthClassGreaterThanOrEqualTo(String value) {
            addCriterion("job_fourth_class >=", value, "job_fourth_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFourthClassLessThan(String value) {
            addCriterion("job_fourth_class <", value, "job_fourth_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFourthClassLessThanOrEqualTo(String value) {
            addCriterion("job_fourth_class <=", value, "job_fourth_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFourthClassLike(String value) {
            addCriterion("job_fourth_class like ", value, "job_fourth_class", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFourthClassNotLike(String value) {
            addCriterion("job_fourth_class  not like ", value, "job_fourth_class", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFourthClassLeftLike(String value) {
            addCriterion("job_fourth_class like ", value, "job_fourth_class", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFourthClassNotLeftLike(String value) {
            addCriterion("job_fourth_class  not like ", value, "job_fourth_class", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFourthClassRightLike(String value) {
            addCriterion("job_fourth_class like ", value, "job_fourth_class", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFourthClassNotRightLike(String value) {
            addCriterion("job_fourth_class  not like ", value, "job_fourth_class", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFourthClassIn(List<String> values) {
            addCriterion("job_fourth_class  in ", values, "job_fourth_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFourthClassNotIn(List<String> values) {
            addCriterion("job_fourth_class not in ", values, "job_fourth_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFourthClassBetween(String value1, String value2) {
            addCriterion("job_fourth_class between ", value1, value2, "job_fourth_class");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobFourthClassNotBetween(String value1, String value2) {
            addCriterion("job_fourth_class not between ", value1, value2, "job_fourth_class");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andIndustryIsNull() {
            addCriterion("industry is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIndustryIsNotNull() {
            addCriterion("industry is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIndustryEqualTo(String value) {
            addCriterion("industry =", value, "industry");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIndustryNotEqualTo(String value) {
            addCriterion("industry <>", value, "industry");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIndustryGreaterThan(String value) {
            addCriterion("industry >", value, "industry");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("industry >=", value, "industry");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIndustryLessThan(String value) {
            addCriterion("industry <", value, "industry");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIndustryLessThanOrEqualTo(String value) {
            addCriterion("industry <=", value, "industry");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIndustryLike(String value) {
            addCriterion("industry like ", value, "industry", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIndustryNotLike(String value) {
            addCriterion("industry  not like ", value, "industry", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIndustryLeftLike(String value) {
            addCriterion("industry like ", value, "industry", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIndustryNotLeftLike(String value) {
            addCriterion("industry  not like ", value, "industry", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIndustryRightLike(String value) {
            addCriterion("industry like ", value, "industry", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIndustryNotRightLike(String value) {
            addCriterion("industry  not like ", value, "industry", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIndustryIn(List<String> values) {
            addCriterion("industry  in ", values, "industry");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIndustryNotIn(List<String> values) {
            addCriterion("industry not in ", values, "industry");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIndustryBetween(String value1, String value2) {
            addCriterion("industry between ", value1, value2, "industry");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIndustryNotBetween(String value1, String value2) {
            addCriterion("industry not between ", value1, value2, "industry");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andStartDateEqualTo(Date value) {
            addCriterion("start_date =", value, "start_date");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andStartDateNotEqualTo(Date value) {
            addCriterion("start_date <>", value, "start_date");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andStartDateGreaterThan(Date value) {
            addCriterion("start_date >", value, "start_date");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("start_date >=", value, "start_date");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andStartDateLessThan(Date value) {
            addCriterion("start_date <", value, "start_date");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterion("start_date <=", value, "start_date");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andStartDateLike(Date value) {
            addCriterion("start_date like ", value, "start_date", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andStartDateNotLike(Date value) {
            addCriterion("start_date  not like ", value, "start_date", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andStartDateLeftLike(Date value) {
            addCriterion("start_date like ", value, "start_date", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andStartDateNotLeftLike(Date value) {
            addCriterion("start_date  not like ", value, "start_date", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andStartDateRightLike(Date value) {
            addCriterion("start_date like ", value, "start_date", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andStartDateNotRightLike(Date value) {
            addCriterion("start_date  not like ", value, "start_date", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andStartDateIn(List<Date> values) {
            addCriterion("start_date  in ", values, "start_date");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andStartDateNotIn(List<Date> values) {
            addCriterion("start_date not in ", values, "start_date");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andStartDateBetween(Date value1, Date value2) {
            addCriterion("start_date between ", value1, value2, "start_date");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterion("start_date not between ", value1, value2, "start_date");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEndDateEqualTo(Date value) {
            addCriterion("end_date =", value, "end_date");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEndDateNotEqualTo(Date value) {
            addCriterion("end_date <>", value, "end_date");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEndDateGreaterThan(Date value) {
            addCriterion("end_date >", value, "end_date");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("end_date >=", value, "end_date");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEndDateLessThan(Date value) {
            addCriterion("end_date <", value, "end_date");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("end_date <=", value, "end_date");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEndDateLike(Date value) {
            addCriterion("end_date like ", value, "end_date", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEndDateNotLike(Date value) {
            addCriterion("end_date  not like ", value, "end_date", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEndDateLeftLike(Date value) {
            addCriterion("end_date like ", value, "end_date", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEndDateNotLeftLike(Date value) {
            addCriterion("end_date  not like ", value, "end_date", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEndDateRightLike(Date value) {
            addCriterion("end_date like ", value, "end_date", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEndDateNotRightLike(Date value) {
            addCriterion("end_date  not like ", value, "end_date", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEndDateIn(List<Date> values) {
            addCriterion("end_date  in ", values, "end_date");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEndDateNotIn(List<Date> values) {
            addCriterion("end_date not in ", values, "end_date");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("end_date between ", value1, value2, "end_date");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("end_date not between ", value1, value2, "end_date");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andSiteIdIsNull() {
            addCriterion("site_id is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteIdIsNotNull() {
            addCriterion("site_id is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteIdEqualTo(String value) {
            addCriterion("site_id =", value, "site_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteIdNotEqualTo(String value) {
            addCriterion("site_id <>", value, "site_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteIdGreaterThan(String value) {
            addCriterion("site_id >", value, "site_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteIdGreaterThanOrEqualTo(String value) {
            addCriterion("site_id >=", value, "site_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteIdLessThan(String value) {
            addCriterion("site_id <", value, "site_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteIdLessThanOrEqualTo(String value) {
            addCriterion("site_id <=", value, "site_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteIdLike(String value) {
            addCriterion("site_id like ", value, "site_id", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteIdNotLike(String value) {
            addCriterion("site_id  not like ", value, "site_id", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteIdLeftLike(String value) {
            addCriterion("site_id like ", value, "site_id", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteIdNotLeftLike(String value) {
            addCriterion("site_id  not like ", value, "site_id", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteIdRightLike(String value) {
            addCriterion("site_id like ", value, "site_id", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteIdNotRightLike(String value) {
            addCriterion("site_id  not like ", value, "site_id", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteIdIn(List<String> values) {
            addCriterion("site_id  in ", values, "site_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteIdNotIn(List<String> values) {
            addCriterion("site_id not in ", values, "site_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteIdBetween(String value1, String value2) {
            addCriterion("site_id between ", value1, value2, "site_id");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteIdNotBetween(String value1, String value2) {
            addCriterion("site_id not between ", value1, value2, "site_id");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andSiteNameIsNull() {
            addCriterion("site_name is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteNameIsNotNull() {
            addCriterion("site_name is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteNameEqualTo(String value) {
            addCriterion("site_name =", value, "site_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteNameNotEqualTo(String value) {
            addCriterion("site_name <>", value, "site_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteNameGreaterThan(String value) {
            addCriterion("site_name >", value, "site_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteNameGreaterThanOrEqualTo(String value) {
            addCriterion("site_name >=", value, "site_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteNameLessThan(String value) {
            addCriterion("site_name <", value, "site_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteNameLessThanOrEqualTo(String value) {
            addCriterion("site_name <=", value, "site_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteNameLike(String value) {
            addCriterion("site_name like ", value, "site_name", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteNameNotLike(String value) {
            addCriterion("site_name  not like ", value, "site_name", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteNameLeftLike(String value) {
            addCriterion("site_name like ", value, "site_name", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteNameNotLeftLike(String value) {
            addCriterion("site_name  not like ", value, "site_name", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteNameRightLike(String value) {
            addCriterion("site_name like ", value, "site_name", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteNameNotRightLike(String value) {
            addCriterion("site_name  not like ", value, "site_name", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteNameIn(List<String> values) {
            addCriterion("site_name  in ", values, "site_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteNameNotIn(List<String> values) {
            addCriterion("site_name not in ", values, "site_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteNameBetween(String value1, String value2) {
            addCriterion("site_name between ", value1, value2, "site_name");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteNameNotBetween(String value1, String value2) {
            addCriterion("site_name not between ", value1, value2, "site_name");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andSiteUrlIsNull() {
            addCriterion("site_url is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteUrlIsNotNull() {
            addCriterion("site_url is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteUrlEqualTo(String value) {
            addCriterion("site_url =", value, "site_url");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteUrlNotEqualTo(String value) {
            addCriterion("site_url <>", value, "site_url");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteUrlGreaterThan(String value) {
            addCriterion("site_url >", value, "site_url");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteUrlGreaterThanOrEqualTo(String value) {
            addCriterion("site_url >=", value, "site_url");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteUrlLessThan(String value) {
            addCriterion("site_url <", value, "site_url");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteUrlLessThanOrEqualTo(String value) {
            addCriterion("site_url <=", value, "site_url");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteUrlLike(String value) {
            addCriterion("site_url like ", value, "site_url", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteUrlNotLike(String value) {
            addCriterion("site_url  not like ", value, "site_url", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteUrlLeftLike(String value) {
            addCriterion("site_url like ", value, "site_url", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteUrlNotLeftLike(String value) {
            addCriterion("site_url  not like ", value, "site_url", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteUrlRightLike(String value) {
            addCriterion("site_url like ", value, "site_url", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteUrlNotRightLike(String value) {
            addCriterion("site_url  not like ", value, "site_url", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteUrlIn(List<String> values) {
            addCriterion("site_url  in ", values, "site_url");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteUrlNotIn(List<String> values) {
            addCriterion("site_url not in ", values, "site_url");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteUrlBetween(String value1, String value2) {
            addCriterion("site_url between ", value1, value2, "site_url");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andSiteUrlNotBetween(String value1, String value2) {
            addCriterion("site_url not between ", value1, value2, "site_url");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andJobUrlIsNull() {
            addCriterion("job_url is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobUrlIsNotNull() {
            addCriterion("job_url is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobUrlEqualTo(String value) {
            addCriterion("job_url =", value, "job_url");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobUrlNotEqualTo(String value) {
            addCriterion("job_url <>", value, "job_url");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobUrlGreaterThan(String value) {
            addCriterion("job_url >", value, "job_url");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobUrlGreaterThanOrEqualTo(String value) {
            addCriterion("job_url >=", value, "job_url");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobUrlLessThan(String value) {
            addCriterion("job_url <", value, "job_url");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobUrlLessThanOrEqualTo(String value) {
            addCriterion("job_url <=", value, "job_url");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobUrlLike(String value) {
            addCriterion("job_url like ", value, "job_url", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobUrlNotLike(String value) {
            addCriterion("job_url  not like ", value, "job_url", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobUrlLeftLike(String value) {
            addCriterion("job_url like ", value, "job_url", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobUrlNotLeftLike(String value) {
            addCriterion("job_url  not like ", value, "job_url", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobUrlRightLike(String value) {
            addCriterion("job_url like ", value, "job_url", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobUrlNotRightLike(String value) {
            addCriterion("job_url  not like ", value, "job_url", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobUrlIn(List<String> values) {
            addCriterion("job_url  in ", values, "job_url");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobUrlNotIn(List<String> values) {
            addCriterion("job_url not in ", values, "job_url");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobUrlBetween(String value1, String value2) {
            addCriterion("job_url between ", value1, value2, "job_url");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andJobUrlNotBetween(String value1, String value2) {
            addCriterion("job_url not between ", value1, value2, "job_url");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andVersionIsNull() {
            addCriterion("version is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andVersionEqualTo(Long value) {
            addCriterion("version =", value, "version");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andVersionNotEqualTo(Long value) {
            addCriterion("version <>", value, "version");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andVersionGreaterThan(Long value) {
            addCriterion("version >", value, "version");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("version >=", value, "version");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andVersionLessThan(Long value) {
            addCriterion("version <", value, "version");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andVersionLessThanOrEqualTo(Long value) {
            addCriterion("version <=", value, "version");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andVersionLike(Long value) {
            addCriterion("version like ", value, "version", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andVersionNotLike(Long value) {
            addCriterion("version  not like ", value, "version", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andVersionLeftLike(Long value) {
            addCriterion("version like ", value, "version", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andVersionNotLeftLike(Long value) {
            addCriterion("version  not like ", value, "version", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andVersionRightLike(Long value) {
            addCriterion("version like ", value, "version", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andVersionNotRightLike(Long value) {
            addCriterion("version  not like ", value, "version", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andVersionIn(List<Long> values) {
            addCriterion("version  in ", values, "version");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andVersionNotIn(List<Long> values) {
            addCriterion("version not in ", values, "version");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andVersionBetween(Long value1, Long value2) {
            addCriterion("version between ", value1, value2, "version");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andVersionNotBetween(Long value1, Long value2) {
            addCriterion("version not between ", value1, value2, "version");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andCtsIsNull() {
            addCriterion("cts is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCtsIsNotNull() {
            addCriterion("cts is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCtsEqualTo(Long value) {
            addCriterion("cts =", value, "cts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCtsNotEqualTo(Long value) {
            addCriterion("cts <>", value, "cts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCtsGreaterThan(Long value) {
            addCriterion("cts >", value, "cts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCtsGreaterThanOrEqualTo(Long value) {
            addCriterion("cts >=", value, "cts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCtsLessThan(Long value) {
            addCriterion("cts <", value, "cts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCtsLessThanOrEqualTo(Long value) {
            addCriterion("cts <=", value, "cts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCtsLike(Long value) {
            addCriterion("cts like ", value, "cts", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCtsNotLike(Long value) {
            addCriterion("cts  not like ", value, "cts", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCtsLeftLike(Long value) {
            addCriterion("cts like ", value, "cts", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCtsNotLeftLike(Long value) {
            addCriterion("cts  not like ", value, "cts", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCtsRightLike(Long value) {
            addCriterion("cts like ", value, "cts", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCtsNotRightLike(Long value) {
            addCriterion("cts  not like ", value, "cts", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCtsIn(List<Long> values) {
            addCriterion("cts  in ", values, "cts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCtsNotIn(List<Long> values) {
            addCriterion("cts not in ", values, "cts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCtsBetween(Long value1, Long value2) {
            addCriterion("cts between ", value1, value2, "cts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andCtsNotBetween(Long value1, Long value2) {
            addCriterion("cts not between ", value1, value2, "cts");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andDtsIsNull() {
            addCriterion("dts is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDtsIsNotNull() {
            addCriterion("dts is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDtsEqualTo(Long value) {
            addCriterion("dts =", value, "dts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDtsNotEqualTo(Long value) {
            addCriterion("dts <>", value, "dts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDtsGreaterThan(Long value) {
            addCriterion("dts >", value, "dts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDtsGreaterThanOrEqualTo(Long value) {
            addCriterion("dts >=", value, "dts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDtsLessThan(Long value) {
            addCriterion("dts <", value, "dts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDtsLessThanOrEqualTo(Long value) {
            addCriterion("dts <=", value, "dts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDtsLike(Long value) {
            addCriterion("dts like ", value, "dts", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDtsNotLike(Long value) {
            addCriterion("dts  not like ", value, "dts", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDtsLeftLike(Long value) {
            addCriterion("dts like ", value, "dts", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDtsNotLeftLike(Long value) {
            addCriterion("dts  not like ", value, "dts", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDtsRightLike(Long value) {
            addCriterion("dts like ", value, "dts", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDtsNotRightLike(Long value) {
            addCriterion("dts  not like ", value, "dts", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDtsIn(List<Long> values) {
            addCriterion("dts  in ", values, "dts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDtsNotIn(List<Long> values) {
            addCriterion("dts not in ", values, "dts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDtsBetween(Long value1, Long value2) {
            addCriterion("dts between ", value1, value2, "dts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andDtsNotBetween(Long value1, Long value2) {
            addCriterion("dts not between ", value1, value2, "dts");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andIdtsIsNull() {
            addCriterion("idts is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIdtsIsNotNull() {
            addCriterion("idts is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIdtsEqualTo(String value) {
            addCriterion("idts =", value, "idts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIdtsNotEqualTo(String value) {
            addCriterion("idts <>", value, "idts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIdtsGreaterThan(String value) {
            addCriterion("idts >", value, "idts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIdtsGreaterThanOrEqualTo(String value) {
            addCriterion("idts >=", value, "idts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIdtsLessThan(String value) {
            addCriterion("idts <", value, "idts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIdtsLessThanOrEqualTo(String value) {
            addCriterion("idts <=", value, "idts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIdtsLike(String value) {
            addCriterion("idts like ", value, "idts", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIdtsNotLike(String value) {
            addCriterion("idts  not like ", value, "idts", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIdtsLeftLike(String value) {
            addCriterion("idts like ", value, "idts", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIdtsNotLeftLike(String value) {
            addCriterion("idts  not like ", value, "idts", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIdtsRightLike(String value) {
            addCriterion("idts like ", value, "idts", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIdtsNotRightLike(String value) {
            addCriterion("idts  not like ", value, "idts", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIdtsIn(List<String> values) {
            addCriterion("idts  in ", values, "idts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIdtsNotIn(List<String> values) {
            addCriterion("idts not in ", values, "idts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIdtsBetween(String value1, String value2) {
            addCriterion("idts between ", value1, value2, "idts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andIdtsNotBetween(String value1, String value2) {
            addCriterion("idts not between ", value1, value2, "idts");
            return (SjJobCriteria) this;
        }
        public SjJobCriteria andTsIsNull() {
            addCriterion("ts is null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andTsIsNotNull() {
            addCriterion("ts is not null");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andTsEqualTo(Long value) {
            addCriterion("ts =", value, "ts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andTsNotEqualTo(Long value) {
            addCriterion("ts <>", value, "ts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andTsGreaterThan(Long value) {
            addCriterion("ts >", value, "ts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andTsGreaterThanOrEqualTo(Long value) {
            addCriterion("ts >=", value, "ts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andTsLessThan(Long value) {
            addCriterion("ts <", value, "ts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andTsLessThanOrEqualTo(Long value) {
            addCriterion("ts <=", value, "ts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andTsLike(Long value) {
            addCriterion("ts like ", value, "ts", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andTsNotLike(Long value) {
            addCriterion("ts  not like ", value, "ts", 1);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andTsLeftLike(Long value) {
            addCriterion("ts like ", value, "ts", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andTsNotLeftLike(Long value) {
            addCriterion("ts  not like ", value, "ts", 0);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andTsRightLike(Long value) {
            addCriterion("ts like ", value, "ts", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andTsNotRightLike(Long value) {
            addCriterion("ts  not like ", value, "ts", 2);
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andTsIn(List<Long> values) {
            addCriterion("ts  in ", values, "ts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andTsNotIn(List<Long> values) {
            addCriterion("ts not in ", values, "ts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andTsBetween(Long value1, Long value2) {
            addCriterion("ts between ", value1, value2, "ts");
            return (SjJobCriteria) this;
        }

        public SjJobCriteria andTsNotBetween(Long value1, Long value2) {
            addCriterion("ts not between ", value1, value2, "ts");
            return (SjJobCriteria) this;
        }

    }

    public static class SjJobCriteria extends GeneratedCriteria {

        protected SjJobCriteria() {
            super();
        }
    }

    public static class SjJobCriterion {
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

        protected SjJobCriterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        protected SjJobCriterion(String condition, Object value, int likeType) {
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

        protected SjJobCriterion(String condition, Object value,
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

        protected SjJobCriterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected SjJobCriterion(String condition, Object value,
                Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected SjJobCriterion(String condition, Object value,
                Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}