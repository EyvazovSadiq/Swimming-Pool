package pool.dao;

import pool.model.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sadiq
 * Date: 6/19/17
 * Time: 2:31 AM
 * To change this template use File | Settings | File Templates.
 */
public interface pool_dao {

    public login check_login(String username , String password) throws Exception ;
    public List<swimmer> get_swimmer_combo()throws Exception ;
    public List<category> get_category_combo() throws Exception ;
    public List<swimmer> get_swimmers() throws Exception ;
    public List<payment> get_payments() throws Exception ;
    public List<coming> get_comings() throws Exception ;
    public List<login> get_logins() throws Exception ;

    public List<swimmer> search_sw(String keyword) throws Exception ;
    public List<payment> search_payment(String keyword) throws Exception ;
    public List<coming> search_coming(String keyword) throws Exception ;
    public List<login> search_worker(String keyword) throws Exception ;

    public void pay(int swimmer_id,int money) throws Exception ;
    public void pay_to_swimmer (pay p) throws Exception ;
    public void register_swimmer(swimmer s) throws Exception ;
    public void insert_coming(int id) throws Exception ;
    public void decrement_sw(int id , int limit) throws Exception ;
    public void delete_sw(int id) throws Exception ;
    public void delete_worker(int id) throws Exception ;
    public void register_worker(login login) throws Exception;

}
