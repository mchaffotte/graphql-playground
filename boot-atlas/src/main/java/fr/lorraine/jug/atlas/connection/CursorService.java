package fr.lorraine.jug.atlas.connection;

import graphql.relay.ConnectionCursor;
import graphql.relay.DefaultConnectionCursor;
import graphql.relay.Edge;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Component
public class CursorService {

    public ConnectionCursor encode(final UUID id) {
        return new DefaultConnectionCursor(Base64.getEncoder().encodeToString(id.toString().getBytes(StandardCharsets.UTF_8)));
    }

    public UUID decode(final String cursor) {
        return UUID.fromString(new String(Base64.getDecoder().decode(cursor)));
    }

    public <T> ConnectionCursor getFirstCursor(final List<Edge<T>> edges) {
        if (edges.isEmpty()) {
            return null;
        }
        return edges.get(0).getCursor();
    }

    public <T> ConnectionCursor getLastCursor(final List<Edge<T>> edges) {
        if (edges.isEmpty()) {
            return null;
        }
        return edges.get(edges.size() - 1).getCursor();
    }
}
