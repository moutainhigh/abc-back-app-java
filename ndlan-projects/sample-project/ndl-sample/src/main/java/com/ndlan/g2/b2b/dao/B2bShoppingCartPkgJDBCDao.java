package com.ndlan.g2.b2b.dao;

import com.ndlan.g2.b2b.model.B2bShoppingCartPkgBean;

import java.util.List;
import org.springframework.jdbc.core.PreparedStatementSetter;
import com.ndlan.canyin.base.repository.BaseDao;
public interface B2bShoppingCartPkgJDBCDao  extends BaseDao<B2bShoppingCartPkgBean, String>{
    /**
     * 根据主键查询
     * @param id 主键id
     * @return 查询对象，无结果时返回null
     */
    public B2bShoppingCartPkgBean selectByPrimaryKey(String cartPkgId);

    /**
     * 根据sql查询
     * @param whereSql where关键字后面的查询条件，例如：id = ?
     * @param params 查询条件中的参数，个数需要与"?"个数保持一致
     * @return 查询结果，无结果时返回空记录集
     */
    public List<B2bShoppingCartPkgBean> selectByWhereSql(String whereSql, Object [] params);

    /**
     * 根据sql分页查询, startPos和num必须一起传入
     * @param whereSql where关键字后面的查询条件，例如：id = ?
     * @param params 查询条件中的参数，个数需要与"?"个数保持一致
     * @param startPos 查询起始位置，从0开始
     * @param num 查询记录数
     * @return 查询结果，无结果时返回空记录集
     */
    public List<B2bShoppingCartPkgBean> selectByWhereSql(String whereSql, Object[] params, Long startPos, Long num);

    /**
     * 查询所有记录
     * @return 所有记录，无结果时返回空记录集
     */
    public List<B2bShoppingCartPkgBean> selectAll();

    /**
     * 统计记录数
     * @param whereSql where关键字后面的查询条件，例如：id = ?
     * @param params 查询条件中的参数，个数需要与"?"个数保持一致
     * @return 记录数
     */
    public long count(String whereSql, Object[] params);

    /**
     * 有选择的插入记录，只插入对象中非null值的字段
     * @param b2bShoppingCartPkg 数据对象
     * @return 成功插入的记录数
     */
    public int insertSelective(B2bShoppingCartPkgBean b2bShoppingCartPkg);

    /**
    * 有选择的插入记录，只插入对象中非null值的字段，并获取主键id到b2bShoppingCartPkg对象中
    * @param b2bShoppingCartPkg 数据对象
    * @return 成功插入的记录数
    */
    public int insertSelectiveAndGetId(B2bShoppingCartPkgBean b2bShoppingCartPkg);

    /**
     * 有选择的更新记录，只更新对象中非null值的字段
     * @param b2bShoppingCartPkg 数据对象
     * @return 成功更新的记录数
     */
    public int updateByPrimaryKeySelective(B2bShoppingCartPkgBean b2bShoppingCartPkg);

    /**
    * 更新数据
    * @param sql 更新语句
    * @param args 参数
    * @return 成功更新的记录数
    */
    public int update(String sql, Object... args);

    /**
    * 更新数据
    * @param sql 更新语句
    * @param pss 参数
    * @return 成功更新的记录数
    */
    public int update(String sql, PreparedStatementSetter pss);

    /**
    * 根据主键删除记录
    * @param id 主键
    * @return 成功删除的记录数
    */
    public int deleteByPrimaryKey(String cartPkgId);

    /**
     * 根据sql语句进行删除
     * @param whereSql where关键字后面的删除条件，例如：id = ?
     * @param params 条件中的参数，个数需要与"?"个数保持一致
     * @return 成功删除的记录数
     */
    public int deleteByWhereSql(String whereSql, Object[] params);
}


