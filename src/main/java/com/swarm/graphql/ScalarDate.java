package com.swarm.graphql;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;

@Component
public class ScalarDate extends GraphQLScalarType {
    public ScalarDate() {
    	super("Date", "Scalar Date", new Coercing() {
    		@Override
            public String serialize(Object input) {
    			Format formatter = new SimpleDateFormat("dd-MMM-yyyy");
    			return formatter.format((Date)input);
            }

            @Override
            public Object parseValue(Object input) {
                return serialize(input);
            }

			@Override
			public Object parseLiteral(Object input) {
				// Implémenter si le type mutation est ajouté
				return null;
			}

        });
    }
}
