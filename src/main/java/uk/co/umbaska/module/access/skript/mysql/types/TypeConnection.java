package uk.co.umbaska.module.access.skript.mysql.types;

import ch.njol.skript.classes.Changer;
import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.lang.*;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.skript.lang.util.SimpleLiteral;
import ch.njol.util.Checker;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import uk.co.umbaska.module.access.AccessModule;
import uk.co.umbaska.module.access.skript.mysql.types.model.AccessConnection;
import uk.co.umbaska.module.access.skript.mysql.types.model.EmptyAccessConnection;
import uk.co.umbaska.skript.UmbaskaExpression;
import uk.co.umbaska.skript.UmbaskaType;

import java.util.Iterator;

/**
 * @author Andrew Tran
 */
public class TypeConnection extends UmbaskaType<AccessConnection>{
    @Override
    public ClassInfo<AccessConnection> getClassInfo() {
        return new ClassInfo<AccessConnection>(AccessConnection.class, "uconnection")
            .parser(new Parser<AccessConnection>() {
                @Override
                public String toString(AccessConnection accessConnection, int i) {
                    return "Connection ID: " + accessConnection.getHost();
                }

                @Override
                public String toVariableNameString(AccessConnection accessConnection) {
                    return toString(accessConnection, 0);
                }

                @Override
                public AccessConnection parse(String s, ParseContext context) {
                    return null;
                }

                @Override
                public boolean canParse(ParseContext context) {
                    return false;
                }

                @Override
                public String getVariableNamePattern() {
                    return "Connection ID: %d+";
                }
            }).defaultExpression(new TypeConnectionDefault());
    }
    public static class TypeConnectionDefault extends SimpleLiteral<AccessConnection>{

        TypeConnectionDefault() {
            super(new EmptyAccessConnection(), true);
        }

        @Override
        public AccessConnection getSingle() {
            if (AccessModule.getInstance().getConnectionManager().keyIsUsed("default")){
                return AccessModule.getInstance().getConnectionManager().getConnection("default");
            }
            return null;
        }
    }
}
