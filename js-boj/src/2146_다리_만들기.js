class Node {
	constructor(value) {
		this.value = value;
		this.next = null;
	}
}

class Queue {
	constructor() {
		this.head = null
		this.tail = null
	}
	
	offer(value) {
		const newNode = new Node(value);
		if(!this.head) {
			this.head = newNode;
			this.tail = newNode;
			return;
		}
		else {
			this.tail.next = newNode;
			this.tail = newNode;
			return;
		}
	}
	
	poll() {
		const removedNode = this.head;
		this.head = removedNode.next;
    if(this.head === null) this.tail = null;
		return removedNode.value;
	}
	
	isEmpty() {
		return this.head === null && this.tail === null;
	}

  clear() {
    this.head = null;
    this.tail = null;
  }
}

const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

let n;
const arr = [];
const d = [[-1, 0], [1, 0], [0, 1], [0, -1]];

const isValidPos = (y, x) => {
  return y >= 0 && x >= 0 && y < n && x < n;
}

// 섬 번호 매기기
const makeIslandNumber = () => {
  let iIdx = 2;
  const isVisited = Array.from({ length: n }, () => Array(n).fill(false));
  
  for(let y = 0; y < n; y++) {
    for(let x = 0; x < n; x++) {

      if(arr[y][x] === 1 && !isVisited[y][x]) {
        isVisited[y][x] = true;
        const q = new Queue();
        q.offer([y, x]);

        while(!q.isEmpty()) {
          const [cy, cx] = q.poll();
          arr[cy][cx] = iIdx;

          for(let i = 0; i < 4; i++) {
            const [ny, nx] = [cy + d[i][0], cx + d[i][1]];
            if(isValidPos(ny, nx) && !isVisited[ny][nx] && arr[ny][nx] === 1) {
              q.offer([ny, nx]);
              isVisited[ny][nx] = true;
            }
          }
        }
        iIdx++;
      }
    }
  }
}

// 인접한 모든 바다의 좌표를 반환
const getNearSea = (y, x) => {
  const blocks = [];
  for(let i = 0; i < 4; i++) {
    const [ny, nx] = [y + d[i][0], x + d[i][1]];
    if(isValidPos(ny, nx) && arr[ny][nx] === 0) {
      blocks.push({ cy: ny, cx: nx, depth: 1, start: arr[y][x] });
    }
  }
  return blocks;
}

const sol = () => {
  makeIslandNumber();

  let min = 50000;
  
  for(let y = 0; y < n; y++) {
    for(let x = 0; x < n; x++) {
      
      // 육지에서 다리 건설 시작
      if(arr[y][x] !== 0) {
        const isVisited = Array.from({ length: n }, () => Array(n).fill(false));
        const q = new Queue();
        getNearSea(y, x).forEach(obj => {
          q.offer(obj);
          isVisited[obj.cy][obj.cx] = true;
        });

        while(!q.isEmpty()) {
          const { cy, cx, depth, start } = q.poll();

          for(let i = 0; i < 4; i++) {
            const [ny, nx] = [cy + d[i][0], cx + d[i][1]];
            if(isValidPos(ny, nx) && !isVisited[ny][nx]) {
              if(arr[ny][nx] === 0) {
                isVisited[ny][nx] = true;
                q.offer({ cy: ny, cx: nx, depth: depth + 1, start });
              }
              else if(arr[ny][nx] !== start) {
                min = Math.min(min, depth);
                q.clear();
                break;  // 최소값 찾았다면, 해당 지역에서 다리 놓는 경우는 더이상 확인하지 않아도 됨
              }
            } 
          }
        }
      }
    }
  }

  return min;
}

rl.on('line', (input) => {
  if(!n) {
    n = +input;
  }
  else {
    arr.push(input.split(' ').map(i => +i));
    if(arr.length === n) { rl.close() };
  }
}).on('close', () => {
  console.log(sol());
})
