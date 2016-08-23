package filters;

import play.mvc.EssentialFilter;
import play.filters.cors.CORSFilter;
import play.http.HttpFilters;

import javax.inject.Inject;

public class Filters implements HttpFilters {


    /**
     * Registered filters.
     *
     * @since 16.03.23
     */
    private final EssentialFilter[] registeredFilters;


    /**
     * Build an instance with injected variables.
     *
     * @param corsFilter           The CORS filter instance
     * @since 16.03.10
     */
    @Inject
    public Filters(final CORSFilter corsFilter) {
        this.registeredFilters = new EssentialFilter[]{ corsFilter.asJava() };
    }


    /**
     * Return the filters that should filter every request.
     *
     * @return filters that should filter every request
     * @since 16.03.23
     */
    @Override
    public EssentialFilter[] filters() {
        return this.registeredFilters;
    }
}
