class CommentsController < ApplicationController

  def destroy
    @comment = Comment.find(params[:id])
    @comment.destroy

    redirect_to @comment.job, notice: "Comentário deletado com sucesso"
  end

  def create
    @job = Job.find(params[:job_id])
    @comment = @job.comments.build(comment_params)

    if @comment.save
      flash[:notice] = "Comentário criado com sucesso"
    else
      flash[:alert] = "Preencha todos os campos"
    end

    redirect_to @job
  end

  private

  def comment_params
    allow = [:name, :body]
    params.require(:comment).permit(allow)
  end

end
