package com.swarm.graphql.query;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.swarm.graphql.model.Breakpoint;
import com.swarm.graphql.model.Product;
import com.swarm.graphql.repository.BreakpointRepository;
import com.swarm.graphql.repository.ProductRepository;

public class QueryBreakpoint  implements GraphQLQueryResolver{

	private BreakpointRepository breakpointRepository;
	private ProductRepository productRepository;
	
	public QueryBreakpoint(BreakpointRepository breakpointRepository, ProductRepository productRepository) {
		this.breakpointRepository = breakpointRepository;
		this.productRepository = productRepository;
	}
	
	
    public Iterable<Breakpoint> allBreakpoints() {
        return breakpointRepository.findAll();
    }
    
    public Iterable<Breakpoint> breakpointsByTaskId(Long taskId){
		return breakpointRepository.findByTaskId(taskId);
    }
    
    public String getTable(Long productId) {
		Product product = productRepository.findOne(productId);
		List<Breakpoint> breakpoints = breakpointRepository.findByProduct(product);

		StringBuffer buffer = new StringBuffer("{");
		long total = breakpoints.size();

		buffer.append("\"draw\": 1,\n");
		buffer.append("\"recordsTotal\": " + total + ",\n");
		buffer.append("\"recordsFiltered\": " + total + ",\n");
		buffer.append("\"data\": [\n");

		for (Breakpoint breakpoint : breakpoints) {
			buffer.append("[\"" + breakpoint.getType().getSession().getTask().getTitle().substring(0, 11) + "\",\n");
			buffer.append("\"" + breakpoint.getType().getSession().getDeveloper().getName() + "\",\n");
			buffer.append("\"" + breakpoint.getType().getFullName() + "\",\n");
			buffer.append("\"" + breakpoint.getLineNumber() + "\"],\n");
		}

		String output = buffer.toString().substring(0, buffer.toString().length() - 2);
		output = output + "\n]}";
        return output;
	}
	
}
