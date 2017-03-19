package uk.co.umbaska.module.access.skript.mysql.effects;

import uk.co.umbaska.module.access.skript.mysql.types.model.PreparedStatement;
import uk.co.umbaska.registrations.annotations.BSyntax;
import uk.co.umbaska.skript.UmbaskaEffect;

/**
 * @author Andrew Tran
 */
@BSyntax(syntax = "(clear|reset|delete) [prepared] [statement][[']s] %upreparedstatement% bind[ing][s]",
        bind = "preparedstatement")
public class EffClearPreparedStatementBatch extends UmbaskaEffect{
    @Override
    public void execute() {
        PreparedStatement preparedStatement = (PreparedStatement) exp().get("preparedstatement");
        if (preparedStatement != null){
           preparedStatement.resetBatch();
        }
    }
}
