const rl = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

let t;
let cur = 1;
const nInput = [];
const pickInput = [];

rl.on("line", (input) => {
  if (!t) t = +input;
  else if (cur <= t) {
    if (nInput.length < cur) {
      nInput.push(+input);
    } else if (pickInput.length < cur) {
      pickInput.push(input.split(" ").map((i) => +i));

      if (cur < t) cur++;
      else rl.close();
    }
  }
}).on("close", () => {
  for (let i = 0; i < t; i++) {
    console.log(sol(i));
  }
});

const sol = (i) => {
  const n = nInput[i];
  const picks = [-1, ...pickInput[i]];
  const isVisited = Array(n + 1).fill(false);
  const isDone = Array(n + 1).fill(false);
  let ans = n;

  const dfs = (now) => {
    isVisited[now] = true;
    const next = picks[now];
    
    if(!isVisited[next]) {
      dfs(next);
    }
    else if(!isDone[next]) {
      for(let i = next; i !== now; i = picks[i]) {
        ans--;
      }
      ans--;
    }
    isDone[now] = true;
  }

  for(let i = 1; i <= n; i ++) {
    if(!isVisited[i]) {
      dfs(i);
    }
  }

  return ans;
}
