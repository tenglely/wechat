package com.wechat.bean;

import java.util.ArrayList;
import java.util.List;

public class GreensExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GreensExample() {
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

        public Criteria andGidIsNull() {
            addCriterion("gid is null");
            return (Criteria) this;
        }

        public Criteria andGidIsNotNull() {
            addCriterion("gid is not null");
            return (Criteria) this;
        }

        public Criteria andGidEqualTo(Integer value) {
            addCriterion("gid =", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotEqualTo(Integer value) {
            addCriterion("gid <>", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThan(Integer value) {
            addCriterion("gid >", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gid >=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThan(Integer value) {
            addCriterion("gid <", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThanOrEqualTo(Integer value) {
            addCriterion("gid <=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidIn(List<Integer> values) {
            addCriterion("gid in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotIn(List<Integer> values) {
            addCriterion("gid not in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidBetween(Integer value1, Integer value2) {
            addCriterion("gid between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotBetween(Integer value1, Integer value2) {
            addCriterion("gid not between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGnameIsNull() {
            addCriterion("gname is null");
            return (Criteria) this;
        }

        public Criteria andGnameIsNotNull() {
            addCriterion("gname is not null");
            return (Criteria) this;
        }

        public Criteria andGnameEqualTo(String value) {
            addCriterion("gname =", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotEqualTo(String value) {
            addCriterion("gname <>", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThan(String value) {
            addCriterion("gname >", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThanOrEqualTo(String value) {
            addCriterion("gname >=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThan(String value) {
            addCriterion("gname <", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThanOrEqualTo(String value) {
            addCriterion("gname <=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLike(String value) {
            addCriterion("gname like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotLike(String value) {
            addCriterion("gname not like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameIn(List<String> values) {
            addCriterion("gname in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotIn(List<String> values) {
            addCriterion("gname not in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameBetween(String value1, String value2) {
            addCriterion("gname between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotBetween(String value1, String value2) {
            addCriterion("gname not between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andGstyleIsNull() {
            addCriterion("gstyle is null");
            return (Criteria) this;
        }

        public Criteria andGstyleIsNotNull() {
            addCriterion("gstyle is not null");
            return (Criteria) this;
        }

        public Criteria andGstyleEqualTo(String value) {
            addCriterion("gstyle =", value, "gstyle");
            return (Criteria) this;
        }

        public Criteria andGstyleNotEqualTo(String value) {
            addCriterion("gstyle <>", value, "gstyle");
            return (Criteria) this;
        }

        public Criteria andGstyleGreaterThan(String value) {
            addCriterion("gstyle >", value, "gstyle");
            return (Criteria) this;
        }

        public Criteria andGstyleGreaterThanOrEqualTo(String value) {
            addCriterion("gstyle >=", value, "gstyle");
            return (Criteria) this;
        }

        public Criteria andGstyleLessThan(String value) {
            addCriterion("gstyle <", value, "gstyle");
            return (Criteria) this;
        }

        public Criteria andGstyleLessThanOrEqualTo(String value) {
            addCriterion("gstyle <=", value, "gstyle");
            return (Criteria) this;
        }

        public Criteria andGstyleLike(String value) {
            addCriterion("gstyle like", value, "gstyle");
            return (Criteria) this;
        }

        public Criteria andGstyleNotLike(String value) {
            addCriterion("gstyle not like", value, "gstyle");
            return (Criteria) this;
        }

        public Criteria andGstyleIn(List<String> values) {
            addCriterion("gstyle in", values, "gstyle");
            return (Criteria) this;
        }

        public Criteria andGstyleNotIn(List<String> values) {
            addCriterion("gstyle not in", values, "gstyle");
            return (Criteria) this;
        }

        public Criteria andGstyleBetween(String value1, String value2) {
            addCriterion("gstyle between", value1, value2, "gstyle");
            return (Criteria) this;
        }

        public Criteria andGstyleNotBetween(String value1, String value2) {
            addCriterion("gstyle not between", value1, value2, "gstyle");
            return (Criteria) this;
        }

        public Criteria andGlabelIsNull() {
            addCriterion("glabel is null");
            return (Criteria) this;
        }

        public Criteria andGlabelIsNotNull() {
            addCriterion("glabel is not null");
            return (Criteria) this;
        }

        public Criteria andGlabelEqualTo(String value) {
            addCriterion("glabel =", value, "glabel");
            return (Criteria) this;
        }

        public Criteria andGlabelNotEqualTo(String value) {
            addCriterion("glabel <>", value, "glabel");
            return (Criteria) this;
        }

        public Criteria andGlabelGreaterThan(String value) {
            addCriterion("glabel >", value, "glabel");
            return (Criteria) this;
        }

        public Criteria andGlabelGreaterThanOrEqualTo(String value) {
            addCriterion("glabel >=", value, "glabel");
            return (Criteria) this;
        }

        public Criteria andGlabelLessThan(String value) {
            addCriterion("glabel <", value, "glabel");
            return (Criteria) this;
        }

        public Criteria andGlabelLessThanOrEqualTo(String value) {
            addCriterion("glabel <=", value, "glabel");
            return (Criteria) this;
        }

        public Criteria andGlabelLike(String value) {
            addCriterion("glabel like", value, "glabel");
            return (Criteria) this;
        }

        public Criteria andGlabelNotLike(String value) {
            addCriterion("glabel not like", value, "glabel");
            return (Criteria) this;
        }

        public Criteria andGlabelIn(List<String> values) {
            addCriterion("glabel in", values, "glabel");
            return (Criteria) this;
        }

        public Criteria andGlabelNotIn(List<String> values) {
            addCriterion("glabel not in", values, "glabel");
            return (Criteria) this;
        }

        public Criteria andGlabelBetween(String value1, String value2) {
            addCriterion("glabel between", value1, value2, "glabel");
            return (Criteria) this;
        }

        public Criteria andGlabelNotBetween(String value1, String value2) {
            addCriterion("glabel not between", value1, value2, "glabel");
            return (Criteria) this;
        }

        public Criteria andGhitsIsNull() {
            addCriterion("ghits is null");
            return (Criteria) this;
        }

        public Criteria andGhitsIsNotNull() {
            addCriterion("ghits is not null");
            return (Criteria) this;
        }

        public Criteria andGhitsEqualTo(Integer value) {
            addCriterion("ghits =", value, "ghits");
            return (Criteria) this;
        }

        public Criteria andGhitsNotEqualTo(Integer value) {
            addCriterion("ghits <>", value, "ghits");
            return (Criteria) this;
        }

        public Criteria andGhitsGreaterThan(Integer value) {
            addCriterion("ghits >", value, "ghits");
            return (Criteria) this;
        }

        public Criteria andGhitsGreaterThanOrEqualTo(Integer value) {
            addCriterion("ghits >=", value, "ghits");
            return (Criteria) this;
        }

        public Criteria andGhitsLessThan(Integer value) {
            addCriterion("ghits <", value, "ghits");
            return (Criteria) this;
        }

        public Criteria andGhitsLessThanOrEqualTo(Integer value) {
            addCriterion("ghits <=", value, "ghits");
            return (Criteria) this;
        }

        public Criteria andGhitsIn(List<Integer> values) {
            addCriterion("ghits in", values, "ghits");
            return (Criteria) this;
        }

        public Criteria andGhitsNotIn(List<Integer> values) {
            addCriterion("ghits not in", values, "ghits");
            return (Criteria) this;
        }

        public Criteria andGhitsBetween(Integer value1, Integer value2) {
            addCriterion("ghits between", value1, value2, "ghits");
            return (Criteria) this;
        }

        public Criteria andGhitsNotBetween(Integer value1, Integer value2) {
            addCriterion("ghits not between", value1, value2, "ghits");
            return (Criteria) this;
        }

        public Criteria andGwriterIsNull() {
            addCriterion("gwriter is null");
            return (Criteria) this;
        }

        public Criteria andGwriterIsNotNull() {
            addCriterion("gwriter is not null");
            return (Criteria) this;
        }

        public Criteria andGwriterEqualTo(String value) {
            addCriterion("gwriter =", value, "gwriter");
            return (Criteria) this;
        }

        public Criteria andGwriterNotEqualTo(String value) {
            addCriterion("gwriter <>", value, "gwriter");
            return (Criteria) this;
        }

        public Criteria andGwriterGreaterThan(String value) {
            addCriterion("gwriter >", value, "gwriter");
            return (Criteria) this;
        }

        public Criteria andGwriterGreaterThanOrEqualTo(String value) {
            addCriterion("gwriter >=", value, "gwriter");
            return (Criteria) this;
        }

        public Criteria andGwriterLessThan(String value) {
            addCriterion("gwriter <", value, "gwriter");
            return (Criteria) this;
        }

        public Criteria andGwriterLessThanOrEqualTo(String value) {
            addCriterion("gwriter <=", value, "gwriter");
            return (Criteria) this;
        }

        public Criteria andGwriterLike(String value) {
            addCriterion("gwriter like", value, "gwriter");
            return (Criteria) this;
        }

        public Criteria andGwriterNotLike(String value) {
            addCriterion("gwriter not like", value, "gwriter");
            return (Criteria) this;
        }

        public Criteria andGwriterIn(List<String> values) {
            addCriterion("gwriter in", values, "gwriter");
            return (Criteria) this;
        }

        public Criteria andGwriterNotIn(List<String> values) {
            addCriterion("gwriter not in", values, "gwriter");
            return (Criteria) this;
        }

        public Criteria andGwriterBetween(String value1, String value2) {
            addCriterion("gwriter between", value1, value2, "gwriter");
            return (Criteria) this;
        }

        public Criteria andGwriterNotBetween(String value1, String value2) {
            addCriterion("gwriter not between", value1, value2, "gwriter");
            return (Criteria) this;
        }

        public Criteria andGdateIsNull() {
            addCriterion("gdate is null");
            return (Criteria) this;
        }

        public Criteria andGdateIsNotNull() {
            addCriterion("gdate is not null");
            return (Criteria) this;
        }

        public Criteria andGdateEqualTo(String value) {
            addCriterion("gdate =", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateNotEqualTo(String value) {
            addCriterion("gdate <>", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateGreaterThan(String value) {
            addCriterion("gdate >", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateGreaterThanOrEqualTo(String value) {
            addCriterion("gdate >=", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateLessThan(String value) {
            addCriterion("gdate <", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateLessThanOrEqualTo(String value) {
            addCriterion("gdate <=", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateLike(String value) {
            addCriterion("gdate like", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateNotLike(String value) {
            addCriterion("gdate not like", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateIn(List<String> values) {
            addCriterion("gdate in", values, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateNotIn(List<String> values) {
            addCriterion("gdate not in", values, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateBetween(String value1, String value2) {
            addCriterion("gdate between", value1, value2, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateNotBetween(String value1, String value2) {
            addCriterion("gdate not between", value1, value2, "gdate");
            return (Criteria) this;
        }

        public Criteria andGneedIsNull() {
            addCriterion("gneed is null");
            return (Criteria) this;
        }

        public Criteria andGneedIsNotNull() {
            addCriterion("gneed is not null");
            return (Criteria) this;
        }

        public Criteria andGneedEqualTo(String value) {
            addCriterion("gneed =", value, "gneed");
            return (Criteria) this;
        }

        public Criteria andGneedNotEqualTo(String value) {
            addCriterion("gneed <>", value, "gneed");
            return (Criteria) this;
        }

        public Criteria andGneedGreaterThan(String value) {
            addCriterion("gneed >", value, "gneed");
            return (Criteria) this;
        }

        public Criteria andGneedGreaterThanOrEqualTo(String value) {
            addCriterion("gneed >=", value, "gneed");
            return (Criteria) this;
        }

        public Criteria andGneedLessThan(String value) {
            addCriterion("gneed <", value, "gneed");
            return (Criteria) this;
        }

        public Criteria andGneedLessThanOrEqualTo(String value) {
            addCriterion("gneed <=", value, "gneed");
            return (Criteria) this;
        }

        public Criteria andGneedLike(String value) {
            addCriterion("gneed like", value, "gneed");
            return (Criteria) this;
        }

        public Criteria andGneedNotLike(String value) {
            addCriterion("gneed not like", value, "gneed");
            return (Criteria) this;
        }

        public Criteria andGneedIn(List<String> values) {
            addCriterion("gneed in", values, "gneed");
            return (Criteria) this;
        }

        public Criteria andGneedNotIn(List<String> values) {
            addCriterion("gneed not in", values, "gneed");
            return (Criteria) this;
        }

        public Criteria andGneedBetween(String value1, String value2) {
            addCriterion("gneed between", value1, value2, "gneed");
            return (Criteria) this;
        }

        public Criteria andGneedNotBetween(String value1, String value2) {
            addCriterion("gneed not between", value1, value2, "gneed");
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