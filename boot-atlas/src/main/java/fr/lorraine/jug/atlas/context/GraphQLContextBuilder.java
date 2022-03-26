package fr.lorraine.jug.atlas.context;

import fr.lorraine.jug.atlas.context.dataloader.DataLoaderRegistryFactory;
import graphql.kickstart.execution.context.GraphQLContext;
import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.servlet.context.GraphQLServletContextBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;

@Component
@RequiredArgsConstructor
public class GraphQLContextBuilder implements GraphQLServletContextBuilder {

    private final DataLoaderRegistryFactory registryFactory;

    @Override
    public GraphQLContext build(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) {
        final String userId = httpServletRequest.getHeader("user_id");
        final DefaultGraphQLServletContext context = DefaultGraphQLServletContext.createServletContext()
                .with(httpServletRequest)
                .with(httpServletResponse)
                .with(registryFactory.create(userId))
                .build();
        return new CustomGraphQLContext(userId, context);
    }

    @Override
    public GraphQLContext build(final Session session, final HandshakeRequest handshakeRequest) {
        throw new IllegalStateException("Not yet supported");
    }

    @Override
    public GraphQLContext build() {
        throw new IllegalStateException("Not yet supported");
    }
}
