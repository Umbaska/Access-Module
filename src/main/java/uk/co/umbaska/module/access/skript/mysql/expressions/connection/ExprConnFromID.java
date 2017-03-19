package uk.co.umbaska.module.access.skript.mysql.expressions.connection;

import uk.co.umbaska.module.access.AccessModule;
import uk.co.umbaska.module.access.skript.mysql.types.model.AccessConnection;
import uk.co.umbaska.registrations.annotations.BSyntax;
import uk.co.umbaska.skript.UmbaskaExpression;

/**
 * @author Andrew Tran
 */
@BSyntax(syntax = "connection from [id] %string%", bind = "id")
public class ExprConnFromID extends UmbaskaExpression<AccessConnection>{
    @Override
    public AccessConnection getValue() {
        return AccessModule.getInstance().getConnectionManager().getConnection(exp().getString("id"));
    }
}
