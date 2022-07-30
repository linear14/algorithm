const solution = (n, wires) => {
  const adjs = Array.from({ length: n + 1 }, () => []);
  for(let i = 0; i < wires.length; i++) {
      adjs[wires[i][0]].push(wires[i][1]);
      adjs[wires[i][1]].push(wires[i][0]);
  }
  
  let ans = 10000;
  for(let i = 1; i <= n; i++) {
      for(let j = 0; j < adjs[i].length; j++) {
          const cutNode = adjs[i][j];
          const q = [];
          const isVisited = Array(n + 1).fill(false);
          let linkedCount = 1;
          
          isVisited[i] = true;
          q.push(i);
          
          while(q.length > 0) {
              const cur = q.shift();
              const nextNodes = adjs[cur].filter(adj => adj !== cutNode);
              
              for(let k = 0; k < nextNodes.length; k++) {
                  const nextNode = nextNodes[k];
                  if(!isVisited[nextNode]) {
                      linkedCount++;
                      isVisited[nextNode] = true;
                      q.push(nextNode);
                  }
              }
          }
          
          ans = Math.min(ans, Math.abs((n - linkedCount) - linkedCount));
      }
  }
  
  return ans;
}