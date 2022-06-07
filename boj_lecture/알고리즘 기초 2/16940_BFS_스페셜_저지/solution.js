const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
const arr = [];
let orders;

// rl.on('line', (input) => {
//   if(!n) {
//     n = +input;
//   }  
//   else if(arr.length < n-1) {
//     arr.push(input.split(' ').map(i => +i));
//   }
//   else {
//     orders = input.split(' ').map(i => +i);
//     rl.close();
//   }
// }).on('close', () => {
//   const adj = Array.from({ length: n + 1 }, () => []);
//   for(let i = 0; i < arr.length; i++) {
//     adj[arr[i][0]].push(arr[i][1]);
//     adj[arr[i][1]].push(arr[i][0]);
//   }
//   const isVisited = Array(n+1).fill(false);
  
//   let current = 0;
//   let adjStartIdx = 1;
//   isVisited[orders[current]] = true;

//   if(orders[current] !== 1) {
//     console.log('0');
//     return;
//   }

//   while(current < n) {
//     const node = orders[current];
//     const nexts = adj[node].filter(node => !isVisited[node]);

//     const adjNodes = orders.slice(adjStartIdx, adjStartIdx + nexts.length);
//     for(let i = 0; i < nexts.length; i++) {
//       isVisited[nexts[i]] = true
//       if(!adjNodes.includes(nexts[i])) {
//         console.log('0');
//         return;
//       }
//       if(i === nexts.length - 1) {
//         adjStartIdx += nexts.length;
//       }
//     }

//     current++;
//   }

//   if(isVisited.filter(item => item === false).length > 1) {
//     console.log('0');
//   }
//   else {
//     console.log('1');
//   }
// });

rl.on('line', (input) => {
  if(!n) {
    n = +input;
  }  
  else if(arr.length < n-1) {
    arr.push(input.split(' ').map(i => +i));
  }
  else {
    orders = input.split(' ').map(i => +i);
    rl.close();
  }
}).on('close', () => {
  const adj = Array.from({ length: n + 1 }, () => []);
  for(let i = 0; i < arr.length; i++) {
    adj[arr[i][0]].push(arr[i][1]);
    adj[arr[i][1]].push(arr[i][0]);
  }
  const isVisited = Array(n+1).fill(false);
  
  let current = 0;
  let adjStartIdx = 1;
  let visitCount = 2;
  isVisited[orders[current]] = true;

  for(let i = 0; i < orders.length; i++) {
    if(i === 0 && orders[i] !== 1) {
      console.log('0');
      return;
    }

    const node = orders[i];
    const nexts = adj[node].filter(node => !isVisited[node]);

    const adjNodes = new Set(orders.slice(adjStartIdx, adjStartIdx + nexts.length));
    for(let j = 0; j < nexts.length; j++) {
      isVisited[nexts[j]] = true;
      visitCount++;
      if(!adjNodes.has(nexts[j])) {
        console.log('0');
        return;
      }
      if(j === nexts.length - 1) {
        adjStartIdx += nexts.length;
      }
    }
  }

  if(visitCount < isVisited.length) {
    console.log('0');
  }
  else {
    console.log('1');
  }
});