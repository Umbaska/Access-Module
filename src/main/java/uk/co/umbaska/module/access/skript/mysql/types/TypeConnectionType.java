package uk.co.umbaska.module.access.skript.mysql.types;

import uk.co.umbaska.module.access.skript.mysql.types.model.AccessConnectionType;
import uk.co.umbaska.skript.UmbaskaEnumType;

/**
 * @author Andrew Tran
 */
public class TypeConnectionType extends UmbaskaEnumType<AccessConnectionType>{
    @Override
    public String getCodeName() {
        return "uconnectiontype";
    }
}
