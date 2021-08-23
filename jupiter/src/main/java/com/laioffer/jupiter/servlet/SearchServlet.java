package com.laioffer.jupiter.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laioffer.jupiter.external.TwitchClient;
import com.laioffer.jupiter.external.TwitchException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      String gameId = request.getParameter("game_id");
      if (gameId == null) {
          response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
          return;
      }

      TwitchClient client = new TwitchClient();
      try {
        ServletUtil.writeItemMap(response, client.searchItems(gameId));
      } catch (TwitchException e) {
          throw new ServletException(e);
      }
  }
}
