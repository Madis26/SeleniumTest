package com.ignite.ee.Database;

import com.ignite.ee.Database.ConnectDatabase;

public class UpdateTables extends ConnectDatabase {
    public void UpdateAuthoritiesTable(){
        String UpdateAuthoritiesSqlJake = "UPDATE authorities SET authority='ROLE_USER' WHERE username='Jake'";
        String UpdateAuthoritiesSqlMaria = "UPDATE authorities SET authority='ROLE_ADMIN' WHERE username='Maria'";        String UpdateAuthoritiesSql = "UPDATE authorities SET authority='ROLE_NEWUSER' WHERE username='Sara'";
        String UpdateAuthoritiesSqlMike = "UPDATE authorities SET authority='ROLE_ADMIN' WHERE username='Mike'";
        String UpdateAuthoritiesSqlSara = "UPDATE authorities SET authority='ROLE_NEWUSER' WHERE username='Sara'";
        String UpdateAuthoritiesSqlTom = "UPDATE authorities SET authority='ROLE_NEWUSER' WHERE username='Tom'";

        ConnectDatabase(UpdateAuthoritiesSqlJake);
        ConnectDatabase(UpdateAuthoritiesSqlMaria);
        ConnectDatabase(UpdateAuthoritiesSqlMike);
        ConnectDatabase(UpdateAuthoritiesSqlSara);
        ConnectDatabase(UpdateAuthoritiesSqlTom);

    }

    public void UpdateUsersTable(){
        String UpdateUsersSqlJake = "UPDATE users SET password='e2a79383c1347633461eb9fb56cf4972a0155919' WHERE username='Jake'";
        String UpdateUsersSqlMaria = "UPDATE users SET password='3e182b1ea9376483a38614d916a0b666ef531b6d' WHERE username='Maria'";        String UpdateAuthoritiesSql = "UPDATE authorities SET authority='ROLE_NEWUSER' WHERE username='Sara'";
        String UpdateUsersSqlMike = "UPDATE users SET password='d6ac022931a66a2bcc244db91818ebec76ce5e18' WHERE username='Mike'";
        String UpdateUsersSqlSara = "UPDATE users SET password='5d569dfc13001c8b30aa11eeb2a59d22071f3d80' WHERE username='Sara'";
        String UpdateUsersSqlTom = "UPDATE users SET password='26d58cf3df0903a2298788b72fced5bca9ea7144' WHERE username='Tom'";

        ConnectDatabase(UpdateUsersSqlJake);
        ConnectDatabase(UpdateUsersSqlMaria);
        ConnectDatabase(UpdateUsersSqlMike);
        ConnectDatabase(UpdateUsersSqlSara);
        ConnectDatabase(UpdateUsersSqlTom);
    }
}
