package com.ztesoft.web.sys.db.arg;

import java.util.*;
import java.math.*;
import org.apache.commons.lang.*;

public class SysCityArg {
    private String pk_name = "city_id";

    private String orderByClause;

    private String groupByClause;

    private String columns;

    private String countsql1;

    private String countsql2;

    private boolean distinct;

    private int rowStart = 0;

    private int rowEnd = 10;

    private List<SysCityCriteria> oredCriteria;

    public SysCityArg() {
        oredCriteria = new ArrayList<SysCityCriteria>();
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

    public List<SysCityCriteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(SysCityCriteria criteria) {
        oredCriteria.add(criteria);
    }

    public SysCityCriteria or() {
    	SysCityCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public SysCityCriteria createCriteria() {
    	SysCityCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected SysCityCriteria createCriteriaInternal() {
    	SysCityCriteria criteria = new SysCityCriteria();
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
        protected List<SysCityCriterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<SysCityCriterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<SysCityCriterion> getAllCriteria() {
            return criteria;
        }

        public List<SysCityCriterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new SysCityCriterion(condition));
        }

        protected void addCriterion(String condition, Object value,
                String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new SysCityCriterion(condition, value));
        }

        protected void addCriterion(String condition, Object value,
                String property, int likeType) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new SysCityCriterion(condition, value, likeType));
        }

        protected void addCriterion(String condition, Object value1,
                Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property
                        + " cannot be null");
            }
            criteria.add(new SysCityCriterion(condition, value1, value2));
        }

        public SysCityCriteria andCriterionEqualTo(String criterion) {
            if (StringUtils.isBlank(criterion)) {
                criterion = "1=1";
            }
            addCriterion(criterion);
            return (SysCityCriteria) this;
        }
        public SysCityCriteria andCityIdIsNull() {
            addCriterion("city_id is null");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityIdIsNotNull() {
            addCriterion("city_id is not null");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityIdEqualTo(Integer value) {
            addCriterion("city_id =", value, "city_id");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityIdNotEqualTo(Integer value) {
            addCriterion("city_id <>", value, "city_id");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityIdGreaterThan(Integer value) {
            addCriterion("city_id >", value, "city_id");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_id >=", value, "city_id");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityIdLessThan(Integer value) {
            addCriterion("city_id <", value, "city_id");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("city_id <=", value, "city_id");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityIdLike(Integer value) {
            addCriterion("city_id like ", value, "city_id", 1);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityIdNotLike(Integer value) {
            addCriterion("city_id  not like ", value, "city_id", 1);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityIdLeftLike(Integer value) {
            addCriterion("city_id like ", value, "city_id", 0);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityIdNotLeftLike(Integer value) {
            addCriterion("city_id  not like ", value, "city_id", 0);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityIdRightLike(Integer value) {
            addCriterion("city_id like ", value, "city_id", 2);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityIdNotRightLike(Integer value) {
            addCriterion("city_id  not like ", value, "city_id", 2);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityIdIn(List<Integer> values) {
            addCriterion("city_id  in ", values, "city_id");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityIdNotIn(List<Integer> values) {
            addCriterion("city_id not in ", values, "city_id");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityIdBetween(Integer value1, Integer value2) {
            addCriterion("city_id between ", value1, value2, "city_id");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("city_id not between ", value1, value2, "city_id");
            return (SysCityCriteria) this;
        }
        public SysCityCriteria andCityNameIsNull() {
            addCriterion("city_name is null");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityNameIsNotNull() {
            addCriterion("city_name is not null");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityNameEqualTo(String value) {
            addCriterion("city_name =", value, "city_name");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityNameNotEqualTo(String value) {
            addCriterion("city_name <>", value, "city_name");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityNameGreaterThan(String value) {
            addCriterion("city_name >", value, "city_name");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("city_name >=", value, "city_name");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityNameLessThan(String value) {
            addCriterion("city_name <", value, "city_name");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityNameLessThanOrEqualTo(String value) {
            addCriterion("city_name <=", value, "city_name");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityNameLike(String value) {
            addCriterion("city_name like ", value, "city_name", 1);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityNameNotLike(String value) {
            addCriterion("city_name  not like ", value, "city_name", 1);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityNameLeftLike(String value) {
            addCriterion("city_name like ", value, "city_name", 0);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityNameNotLeftLike(String value) {
            addCriterion("city_name  not like ", value, "city_name", 0);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityNameRightLike(String value) {
            addCriterion("city_name like ", value, "city_name", 2);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityNameNotRightLike(String value) {
            addCriterion("city_name  not like ", value, "city_name", 2);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityNameIn(List<String> values) {
            addCriterion("city_name  in ", values, "city_name");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityNameNotIn(List<String> values) {
            addCriterion("city_name not in ", values, "city_name");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityNameBetween(String value1, String value2) {
            addCriterion("city_name between ", value1, value2, "city_name");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityNameNotBetween(String value1, String value2) {
            addCriterion("city_name not between ", value1, value2, "city_name");
            return (SysCityCriteria) this;
        }
        public SysCityCriteria andCityShortIsNull() {
            addCriterion("city_short is null");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityShortIsNotNull() {
            addCriterion("city_short is not null");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityShortEqualTo(String value) {
            addCriterion("city_short =", value, "city_short");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityShortNotEqualTo(String value) {
            addCriterion("city_short <>", value, "city_short");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityShortGreaterThan(String value) {
            addCriterion("city_short >", value, "city_short");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityShortGreaterThanOrEqualTo(String value) {
            addCriterion("city_short >=", value, "city_short");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityShortLessThan(String value) {
            addCriterion("city_short <", value, "city_short");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityShortLessThanOrEqualTo(String value) {
            addCriterion("city_short <=", value, "city_short");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityShortLike(String value) {
            addCriterion("city_short like ", value, "city_short", 1);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityShortNotLike(String value) {
            addCriterion("city_short  not like ", value, "city_short", 1);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityShortLeftLike(String value) {
            addCriterion("city_short like ", value, "city_short", 0);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityShortNotLeftLike(String value) {
            addCriterion("city_short  not like ", value, "city_short", 0);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityShortRightLike(String value) {
            addCriterion("city_short like ", value, "city_short", 2);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityShortNotRightLike(String value) {
            addCriterion("city_short  not like ", value, "city_short", 2);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityShortIn(List<String> values) {
            addCriterion("city_short  in ", values, "city_short");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityShortNotIn(List<String> values) {
            addCriterion("city_short not in ", values, "city_short");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityShortBetween(String value1, String value2) {
            addCriterion("city_short between ", value1, value2, "city_short");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityShortNotBetween(String value1, String value2) {
            addCriterion("city_short not between ", value1, value2, "city_short");
            return (SysCityCriteria) this;
        }
        public SysCityCriteria andHotIsNull() {
            addCriterion("hot is null");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andHotIsNotNull() {
            addCriterion("hot is not null");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andHotEqualTo(String value) {
            addCriterion("hot =", value, "hot");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andHotNotEqualTo(String value) {
            addCriterion("hot <>", value, "hot");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andHotGreaterThan(String value) {
            addCriterion("hot >", value, "hot");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andHotGreaterThanOrEqualTo(String value) {
            addCriterion("hot >=", value, "hot");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andHotLessThan(String value) {
            addCriterion("hot <", value, "hot");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andHotLessThanOrEqualTo(String value) {
            addCriterion("hot <=", value, "hot");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andHotLike(String value) {
            addCriterion("hot like ", value, "hot", 1);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andHotNotLike(String value) {
            addCriterion("hot  not like ", value, "hot", 1);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andHotLeftLike(String value) {
            addCriterion("hot like ", value, "hot", 0);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andHotNotLeftLike(String value) {
            addCriterion("hot  not like ", value, "hot", 0);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andHotRightLike(String value) {
            addCriterion("hot like ", value, "hot", 2);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andHotNotRightLike(String value) {
            addCriterion("hot  not like ", value, "hot", 2);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andHotIn(List<String> values) {
            addCriterion("hot  in ", values, "hot");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andHotNotIn(List<String> values) {
            addCriterion("hot not in ", values, "hot");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andHotBetween(String value1, String value2) {
            addCriterion("hot between ", value1, value2, "hot");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andHotNotBetween(String value1, String value2) {
            addCriterion("hot not between ", value1, value2, "hot");
            return (SysCityCriteria) this;
        }
        public SysCityCriteria andCityPinyinIsNull() {
            addCriterion("city_pinyin is null");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityPinyinIsNotNull() {
            addCriterion("city_pinyin is not null");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityPinyinEqualTo(String value) {
            addCriterion("city_pinyin =", value, "city_pinyin");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityPinyinNotEqualTo(String value) {
            addCriterion("city_pinyin <>", value, "city_pinyin");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityPinyinGreaterThan(String value) {
            addCriterion("city_pinyin >", value, "city_pinyin");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityPinyinGreaterThanOrEqualTo(String value) {
            addCriterion("city_pinyin >=", value, "city_pinyin");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityPinyinLessThan(String value) {
            addCriterion("city_pinyin <", value, "city_pinyin");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityPinyinLessThanOrEqualTo(String value) {
            addCriterion("city_pinyin <=", value, "city_pinyin");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityPinyinLike(String value) {
            addCriterion("city_pinyin like ", value, "city_pinyin", 1);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityPinyinNotLike(String value) {
            addCriterion("city_pinyin  not like ", value, "city_pinyin", 1);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityPinyinLeftLike(String value) {
            addCriterion("city_pinyin like ", value, "city_pinyin", 0);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityPinyinNotLeftLike(String value) {
            addCriterion("city_pinyin  not like ", value, "city_pinyin", 0);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityPinyinRightLike(String value) {
            addCriterion("city_pinyin like ", value, "city_pinyin", 2);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityPinyinNotRightLike(String value) {
            addCriterion("city_pinyin  not like ", value, "city_pinyin", 2);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityPinyinIn(List<String> values) {
            addCriterion("city_pinyin  in ", values, "city_pinyin");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityPinyinNotIn(List<String> values) {
            addCriterion("city_pinyin not in ", values, "city_pinyin");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityPinyinBetween(String value1, String value2) {
            addCriterion("city_pinyin between ", value1, value2, "city_pinyin");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCityPinyinNotBetween(String value1, String value2) {
            addCriterion("city_pinyin not between ", value1, value2, "city_pinyin");
            return (SysCityCriteria) this;
        }
        public SysCityCriteria andFirstCharIsNull() {
            addCriterion("first_char is null");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andFirstCharIsNotNull() {
            addCriterion("first_char is not null");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andFirstCharEqualTo(String value) {
            addCriterion("first_char =", value, "first_char");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andFirstCharNotEqualTo(String value) {
            addCriterion("first_char <>", value, "first_char");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andFirstCharGreaterThan(String value) {
            addCriterion("first_char >", value, "first_char");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andFirstCharGreaterThanOrEqualTo(String value) {
            addCriterion("first_char >=", value, "first_char");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andFirstCharLessThan(String value) {
            addCriterion("first_char <", value, "first_char");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andFirstCharLessThanOrEqualTo(String value) {
            addCriterion("first_char <=", value, "first_char");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andFirstCharLike(String value) {
            addCriterion("first_char like ", value, "first_char", 1);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andFirstCharNotLike(String value) {
            addCriterion("first_char  not like ", value, "first_char", 1);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andFirstCharLeftLike(String value) {
            addCriterion("first_char like ", value, "first_char", 0);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andFirstCharNotLeftLike(String value) {
            addCriterion("first_char  not like ", value, "first_char", 0);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andFirstCharRightLike(String value) {
            addCriterion("first_char like ", value, "first_char", 2);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andFirstCharNotRightLike(String value) {
            addCriterion("first_char  not like ", value, "first_char", 2);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andFirstCharIn(List<String> values) {
            addCriterion("first_char  in ", values, "first_char");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andFirstCharNotIn(List<String> values) {
            addCriterion("first_char not in ", values, "first_char");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andFirstCharBetween(String value1, String value2) {
            addCriterion("first_char between ", value1, value2, "first_char");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andFirstCharNotBetween(String value1, String value2) {
            addCriterion("first_char not between ", value1, value2, "first_char");
            return (SysCityCriteria) this;
        }
        public SysCityCriteria andSortNumIsNull() {
            addCriterion("sort_num is null");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andSortNumIsNotNull() {
            addCriterion("sort_num is not null");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andSortNumEqualTo(Integer value) {
            addCriterion("sort_num =", value, "sort_num");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andSortNumNotEqualTo(Integer value) {
            addCriterion("sort_num <>", value, "sort_num");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andSortNumGreaterThan(Integer value) {
            addCriterion("sort_num >", value, "sort_num");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andSortNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort_num >=", value, "sort_num");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andSortNumLessThan(Integer value) {
            addCriterion("sort_num <", value, "sort_num");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andSortNumLessThanOrEqualTo(Integer value) {
            addCriterion("sort_num <=", value, "sort_num");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andSortNumLike(Integer value) {
            addCriterion("sort_num like ", value, "sort_num", 1);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andSortNumNotLike(Integer value) {
            addCriterion("sort_num  not like ", value, "sort_num", 1);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andSortNumLeftLike(Integer value) {
            addCriterion("sort_num like ", value, "sort_num", 0);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andSortNumNotLeftLike(Integer value) {
            addCriterion("sort_num  not like ", value, "sort_num", 0);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andSortNumRightLike(Integer value) {
            addCriterion("sort_num like ", value, "sort_num", 2);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andSortNumNotRightLike(Integer value) {
            addCriterion("sort_num  not like ", value, "sort_num", 2);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andSortNumIn(List<Integer> values) {
            addCriterion("sort_num  in ", values, "sort_num");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andSortNumNotIn(List<Integer> values) {
            addCriterion("sort_num not in ", values, "sort_num");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andSortNumBetween(Integer value1, Integer value2) {
            addCriterion("sort_num between ", value1, value2, "sort_num");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andSortNumNotBetween(Integer value1, Integer value2) {
            addCriterion("sort_num not between ", value1, value2, "sort_num");
            return (SysCityCriteria) this;
        }
        public SysCityCriteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "create_date");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "create_date");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "create_date");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "create_date");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "create_date");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "create_date");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCreateDateLike(Date value) {
            addCriterion("create_date like ", value, "create_date", 1);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCreateDateNotLike(Date value) {
            addCriterion("create_date  not like ", value, "create_date", 1);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCreateDateLeftLike(Date value) {
            addCriterion("create_date like ", value, "create_date", 0);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCreateDateNotLeftLike(Date value) {
            addCriterion("create_date  not like ", value, "create_date", 0);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCreateDateRightLike(Date value) {
            addCriterion("create_date like ", value, "create_date", 2);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCreateDateNotRightLike(Date value) {
            addCriterion("create_date  not like ", value, "create_date", 2);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date  in ", values, "create_date");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in ", values, "create_date");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between ", value1, value2, "create_date");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between ", value1, value2, "create_date");
            return (SysCityCriteria) this;
        }
        public SysCityCriteria andStateIsNull() {
            addCriterion("state is null");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andStateLike(String value) {
            addCriterion("state like ", value, "state", 1);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andStateNotLike(String value) {
            addCriterion("state  not like ", value, "state", 1);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andStateLeftLike(String value) {
            addCriterion("state like ", value, "state", 0);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andStateNotLeftLike(String value) {
            addCriterion("state  not like ", value, "state", 0);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andStateRightLike(String value) {
            addCriterion("state like ", value, "state", 2);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andStateNotRightLike(String value) {
            addCriterion("state  not like ", value, "state", 2);
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andStateIn(List<String> values) {
            addCriterion("state  in ", values, "state");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andStateNotIn(List<String> values) {
            addCriterion("state not in ", values, "state");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andStateBetween(String value1, String value2) {
            addCriterion("state between ", value1, value2, "state");
            return (SysCityCriteria) this;
        }

        public SysCityCriteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between ", value1, value2, "state");
            return (SysCityCriteria) this;
        }

    }

    public static class SysCityCriteria extends GeneratedCriteria {

        protected SysCityCriteria() {
            super();
        }
    }

    public static class SysCityCriterion {
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

        protected SysCityCriterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        protected SysCityCriterion(String condition, Object value, int likeType) {
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

        protected SysCityCriterion(String condition, Object value,
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

        protected SysCityCriterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected SysCityCriterion(String condition, Object value,
                Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected SysCityCriterion(String condition, Object value,
                Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}