package pool.service;

import pool.dao.pool_dao;
import pool.model.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sadiq
 * Date: 6/19/17
 * Time: 2:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class pool_service_dao_impl implements pool_service_dao {

    private pool_dao dao ;
    public pool_service_dao_impl(pool_dao dao){
        this.dao=dao;
    }

    @Override
    public login check_login(String username, String password) throws Exception {
        return dao.check_login(username,password);
    }

    @Override
    public List<login> get_logins() throws Exception {
        return dao.get_logins();
    }

    @Override
    public List<swimmer> get_swimmer_combo() throws Exception {
        return dao.get_swimmer_combo();
    }

    @Override
    public void register_swimmer(swimmer s) throws Exception {
        dao.register_swimmer(s);
    }

    @Override
    public List<category> get_category_combo() throws Exception {
        return dao.get_category_combo();
    }

    @Override
    public List<swimmer> get_swimmers() throws Exception {
        return dao.get_swimmers();
    }

    @Override
    public List<payment> get_payments() throws Exception {
        return dao.get_payments();
    }

    @Override
    public List<coming> get_comings() throws Exception {
        return dao.get_comings();
    }

    @Override
    public void pay(int swimmer_id, int money) throws Exception {
        dao.pay(swimmer_id, money);
    }

    @Override
    public void pay_to_swimmer(pay p) throws Exception {
        dao.pay_to_swimmer(p);
    }

    @Override
    public List<swimmer> search_sw(String keyword) throws Exception {
        return dao.search_sw(keyword);
    }

    @Override
    public List<payment> search_payment(String keyword) throws Exception {
        return dao.search_payment(keyword);
    }

    @Override
    public List<coming> search_coming(String keyword) throws Exception {
        return dao.search_coming(keyword);
    }

    @Override
    public List<login> search_worker(String keyword) throws Exception {
        return dao.search_worker(keyword);
    }

    @Override
    public void decrement_sw(int id , int limit) throws Exception {
        dao.decrement_sw(id ,limit);
    }

    @Override
    public void insert_coming(int id) throws Exception {
        dao.insert_coming(id);
    }

    @Override
    public void delete_sw(int id) throws Exception {
        dao.delete_sw(id);
    }

    @Override
    public void delete_worker(int id) throws Exception {
        dao.delete_worker(id);
    }

    @Override
    public void register_worker(login login) throws Exception {
        dao.register_worker(login);
    }
}
