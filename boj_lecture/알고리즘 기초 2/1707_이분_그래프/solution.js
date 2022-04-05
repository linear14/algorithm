const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let k;
let cur = 1;
let needLength = 0;
const metas = [];
const links = [];
rl.on('line', (input) => {
  if(!k) k = +input;
  else if(metas.length !== cur) {
    metas.push(input.split(' ').map(i => +i));
    needLength += metas[cur - 1][1];
  }
  else {
    links.push(input.split(' ').map(i => +i));
    if(links.length === needLength) {
      cur++;
    }
  }
  if(k + 1 === cur) rl.close();
}).on('close', () => {
  
  let start = 0;

  for(let i = 0; i < k; i++) {
    const [v, e] = metas[i];
    const adj = Array.from({ length: v + 1 }, () => []);

    for(let i = start; i < start + e; i++) {
      adj[links[i][0]].push(links[i][1]);
      adj[links[i][1]].push(links[i][0]);
    }

    start += e;
    
    let endFlag = false;
    const typeList = Array(v + 1).fill();
    const q = new Queue();
    
    for(let j = 1; j <= v; j++) {
      if(!typeList[j]) {
        typeList[j] = 1;
        q.push({ value: j, type: 1 });

        while(q.size !== 0) {
          const { value, type } = q.pop();
          const nexts = adj[value];

          for(let x = 0; x < nexts.length; x++) {
            const next = nexts[x];
            const nextType = typeList[next];

            if(!nextType) {
              const newType = type === 1 ? 2 : 1;
              typeList[next] = newType;
              q.push({ value: next, type: newType });
            }
            else {
              // 다음 노드의 타입이 현재 타입과 같다면 틀리게 된다.
              if(nextType === type) {
                endFlag = true;
              }
            }

            if(endFlag) break;
          }
          if(endFlag) break;
        }
      }
      if(endFlag) break;
    }

    console.log(endFlag ? 'NO' : 'YES');
  }
});

class Node {
  constructor(value) {
    this.value = value;
    this.prev = null;
    this.next = null;
  }
}

class Queue {
  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  push(value) {
    const node = new Node(value);
    
    if(this.size === 0) {
      this.head = node;
      this.tail = node;
    }
    else {
      this.tail.next = node;
      this.tail = node;
    }
    this.size++;
  }

  pop() {
    if(this.size === 0) {
      return;
    }
    
    const node = this.head;

    if(this.size === 1) {
      this.head = null;
      this.tail = null;
    }
    else {
      this.head = this.head.next;
      this.head.prev = null;
    }
    this.size--;

    return node.value;
  }
}