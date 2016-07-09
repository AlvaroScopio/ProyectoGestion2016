package clases;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("*.xhtml")
public class SessionUrlFilter implements Filter{

    FilterConfig filterConfig;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(true);
        
        String requestUrl = req.getRequestURL().toString();
        
        String[] urlPermitidaSinSession = new String[]
        {
            "faces/index.xhtml", 
            "faces/preinscripcion/preinscripcion3.xhtml", 
            "faces/preinscripcion/preinscripcion4.xhtml"
        };
        
        boolean redireccionarPeticion;
        
        if(session.getAttribute("user") == null){
            redireccionarPeticion = true;
            for(String item : urlPermitidaSinSession){
                if(requestUrl.contains(item)){
                    redireccionarPeticion = false;
                    break;
                }
            }
        } else {
            redireccionarPeticion = false;
        }
            
        if(redireccionarPeticion == true){
                res.sendRedirect(req.getContextPath()+"/faces/index.xhtml");
        } else {
                chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
    
}
