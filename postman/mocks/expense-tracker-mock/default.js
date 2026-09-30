const http = require("http");

const server = http.createServer((req, res) => {
  const method = req.method;
  const url = req.url.split("?")[0];
  const segments = url.split("/").filter(Boolean);

  res.setHeader("Content-Type", "application/json");

  // ── CATEGORIES ──────────────────────────────────────────────

  // @endpoint GET /categories
  if (method === "GET" && url === "/categories") {
    res.writeHead(200);
    return res.end(JSON.stringify([
      { id: "cat_1", name: "Travel", description: "Travel-related expenses" },
      { id: "cat_2", name: "Meals", description: "Food and dining expenses" },
      { id: "cat_3", name: "Office Supplies", description: "Office supply purchases" }
    ]));
  }

  // @endpoint POST /categories
  if (method === "POST" && url === "/categories") {
    let body = "";
    req.on("data", chunk => { body += chunk; });
    req.on("end", () => {
      let data = {};
      try { data = JSON.parse(body); } catch (e) {}
      res.writeHead(201);
      res.end(JSON.stringify({ id: "cat_new", ...data, created_at: new Date().toISOString() }));
    });
    return;
  }

  // @endpoint GET /categories/:category_id
  if (method === "GET" && segments.length === 2 && segments[0] === "categories") {
    const category_id = segments[1];
    res.writeHead(200);
    return res.end(JSON.stringify({ id: category_id, name: "Travel", description: "Travel-related expenses" }));
  }

  // @endpoint PUT /categories/:category_id
  if (method === "PUT" && segments.length === 2 && segments[0] === "categories") {
    const category_id = segments[1];
    let body = "";
    req.on("data", chunk => { body += chunk; });
    req.on("end", () => {
      let data = {};
      try { data = JSON.parse(body); } catch (e) {}
      res.writeHead(200);
      res.end(JSON.stringify({ id: category_id, ...data, updated_at: new Date().toISOString() }));
    });
    return;
  }

  // ── EXPENSES ─────────────────────────────────────────────────

  // @endpoint GET /expenses
  if (method === "GET" && url === "/expenses") {
    res.writeHead(200);
    return res.end(JSON.stringify([
      { id: "exp_1", category_id: "cat_1", amount: 250.00, currency: "USD", description: "Flight to NYC", date: "2025-01-15", status: "pending" },
      { id: "exp_2", category_id: "cat_2", amount: 45.50, currency: "USD", description: "Team lunch", date: "2025-01-16", status: "approved" }
    ]));
  }

  // @endpoint POST /expenses
  if (method === "POST" && url === "/expenses") {
    let body = "";
    req.on("data", chunk => { body += chunk; });
    req.on("end", () => {
      let data = {};
      try { data = JSON.parse(body); } catch (e) {}
      res.writeHead(201);
      res.end(JSON.stringify({ id: "exp_new", status: "pending", ...data, created_at: new Date().toISOString() }));
    });
    return;
  }

  // @endpoint GET /expenses/:expense_id
  if (method === "GET" && segments.length === 2 && segments[0] === "expenses") {
    const expense_id = segments[1];
    res.writeHead(200);
    return res.end(JSON.stringify({ id: expense_id, category_id: "cat_1", amount: 250.00, currency: "USD", description: "Flight to NYC", date: "2025-01-15", status: "pending" }));
  }

  // @endpoint PUT /expenses/:expense_id
  if (method === "PUT" && segments.length === 2 && segments[0] === "expenses") {
    const expense_id = segments[1];
    let body = "";
    req.on("data", chunk => { body += chunk; });
    req.on("end", () => {
      let data = {};
      try { data = JSON.parse(body); } catch (e) {}
      res.writeHead(200);
      res.end(JSON.stringify({ id: expense_id, ...data, updated_at: new Date().toISOString() }));
    });
    return;
  }

  // @endpoint DELETE /expenses/:expense_id
  if (method === "DELETE" && segments.length === 2 && segments[0] === "expenses") {
    res.writeHead(204);
    return res.end();
  }

  // ── CLAIMS ───────────────────────────────────────────────────

  // @endpoint GET /claims
  if (method === "GET" && url === "/claims") {
    res.writeHead(200);
    return res.end(JSON.stringify([
      { id: "clm_1", expense_ids: ["exp_1"], status: "submitted", total: 250.00, currency: "USD", submitted_at: "2025-01-17T10:00:00Z" },
      { id: "clm_2", expense_ids: ["exp_2"], status: "approved", total: 45.50, currency: "USD", submitted_at: "2025-01-18T09:00:00Z" }
    ]));
  }

  // @endpoint POST /claims
  if (method === "POST" && url === "/claims") {
    let body = "";
    req.on("data", chunk => { body += chunk; });
    req.on("end", () => {
      let data = {};
      try { data = JSON.parse(body); } catch (e) {}
      res.writeHead(201);
      res.end(JSON.stringify({ id: "clm_new", status: "draft", ...data, created_at: new Date().toISOString() }));
    });
    return;
  }

  // @endpoint GET /claims/:claim_id
  if (method === "GET" && segments.length === 2 && segments[0] === "claims") {
    const claim_id = segments[1];
    res.writeHead(200);
    return res.end(JSON.stringify({ id: claim_id, expense_ids: ["exp_1"], status: "submitted", total: 250.00, currency: "USD", submitted_at: "2025-01-17T10:00:00Z" }));
  }

  // @endpoint POST /claims/:claim_id/approve
  if (method === "POST" && segments.length === 3 && segments[0] === "claims" && segments[2] === "approve") {
    const claim_id = segments[1];
    res.writeHead(200);
    return res.end(JSON.stringify({ id: claim_id, status: "approved", approved_at: new Date().toISOString() }));
  }

  // @endpoint POST /claims/:claim_id/reject
  if (method === "POST" && segments.length === 3 && segments[0] === "claims" && segments[2] === "reject") {
    const claim_id = segments[1];
    res.writeHead(200);
    return res.end(JSON.stringify({ id: claim_id, status: "rejected", rejected_at: new Date().toISOString() }));
  }

  // @endpoint POST /claims/:claim_id/submit
  if (method === "POST" && segments.length === 3 && segments[0] === "claims" && segments[2] === "submit") {
    const claim_id = segments[1];
    res.writeHead(200);
    return res.end(JSON.stringify({ id: claim_id, status: "submitted", submitted_at: new Date().toISOString() }));
  }

  // @endpoint POST /claims/:claim_id/reimburse
  if (method === "POST" && segments.length === 3 && segments[0] === "claims" && segments[2] === "reimburse") {
    const claim_id = segments[1];
    res.writeHead(200);
    return res.end(JSON.stringify({ id: claim_id, status: "reimbursed", reimbursed_at: new Date().toISOString() }));
  }

  // ── 404 FALLBACK ─────────────────────────────────────────────
  res.writeHead(404);
  res.end(JSON.stringify({ error: "Not Found", path: url, method }));
});

server.listen(process.env.PORT || 9000, () => {
  console.log("Expense Tracker Mock running on port " + (process.env.PORT || 9000));
});
