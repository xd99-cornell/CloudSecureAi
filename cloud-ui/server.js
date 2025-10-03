const http = require('http');
const fs = require('fs');
const path = require('path');

const server = http.createServer((req, res) => {
  console.log(`${req.method} ${req.url}`);
  
  // Handle Angular routes - serve index.html for any route
  let filePath = '.' + req.url;
  if (filePath === './') {
    filePath = './index.html';
  } else if (req.url.startsWith('/dashboard') || req.url.startsWith('/admin') || 
             req.url.startsWith('/cloud-accounts') || req.url.startsWith('/resources') ||
             req.url.startsWith('/compliance') || req.url.startsWith('/vulnerabilities') ||
             req.url.startsWith('/k8s-clusters') || req.url.startsWith('/container-images') ||
             req.url.startsWith('/code-security') || req.url.startsWith('/reports') ||
             req.url.startsWith('/settings') || req.url.startsWith('/profile')) {
    filePath = './index.html';
  } else if (req.url.startsWith('/src/')) {
    filePath = '.' + req.url;
  } else if (req.url.startsWith('/assets/')) {
    filePath = './src' + req.url;
  }

  const extname = String(path.extname(filePath)).toLowerCase();
  const mimeTypes = {
    '.html': 'text/html',
    '.js': 'text/javascript',
    '.css': 'text/css',
    '.json': 'application/json',
    '.png': 'image/png',
    '.jpg': 'image/jpg',
    '.gif': 'image/gif',
    '.svg': 'image/svg+xml',
    '.wav': 'audio/wav',
    '.mp4': 'video/mp4',
    '.woff': 'application/font-woff',
    '.ttf': 'application/font-ttf',
    '.eot': 'application/vnd.ms-fontobject',
    '.otf': 'application/font-otf',
    '.wasm': 'application/wasm'
  };

  const contentType = mimeTypes[extname] || 'application/octet-stream';

  fs.readFile(filePath, (error, content) => {
    if (error) {
      if (error.code == 'ENOENT') {
        // If file not found, serve index.html (for Angular routing)
        fs.readFile('./index.html', (err, indexContent) => {
          if (err) {
            res.writeHead(404, { 'Content-Type': 'text/html' });
            res.end('<h1>404 Not Found</h1><p>The requested file was not found.</p>', 'utf-8');
          } else {
            res.writeHead(200, { 'Content-Type': 'text/html' });
            res.end(indexContent, 'utf-8');
          }
        });
      } else {
        res.writeHead(500);
        res.end(`Sorry, check with the site admin for error: ${error.code} ..\n`);
      }
    } else {
      res.writeHead(200, { 'Content-Type': contentType });
      res.end(content, 'utf-8');
    }
  });
});

const PORT = 4200;
server.listen(PORT, () => {
  console.log(`🚀 CouldSecureAI UI Server running at http://localhost:${PORT}/`);
  console.log(`📊 Dashboard: http://localhost:${PORT}/dashboard`);
  console.log(`🛡️  Security Features:`);
  console.log(`   - Cloud Accounts: http://localhost:${PORT}/cloud-accounts`);
  console.log(`   - Resources: http://localhost:${PORT}/resources`);
  console.log(`   - Compliance: http://localhost:${PORT}/compliance`);
  console.log(`   - Vulnerabilities: http://localhost:${PORT}/vulnerabilities`);
  console.log(`   - K8s Clusters: http://localhost:${PORT}/k8s-clusters`);
  console.log(`   - Container Images: http://localhost:${PORT}/container-images`);
  console.log(`   - Code Security: http://localhost:${PORT}/code-security`);
  console.log(`   - Reports: http://localhost:${PORT}/reports`);
  console.log(`   - Settings: http://localhost:${PORT}/settings`);
  console.log(`🔗 Backend API: Expected at http://localhost:8080/api`);
});
