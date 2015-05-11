package DirectedGraph;
class WeightedEdge extends Edge implements Comparable<WeightedEdge>{
		double weight;
		public WeightedEdge(int begin, int end, WeightedEdge next, double weight){
			super(begin,end,next);
			this.weight=weight;
		}
		
		public String toString(){
			return "<"+begin+","+end+"("+weight+")"+">";
		}
		
		@Override
		public int compareTo(WeightedEdge o) {
			if (weight>o.weight) return 1;
			else if (weight==o.weight) return 0;
			else return -1;
		}
	}