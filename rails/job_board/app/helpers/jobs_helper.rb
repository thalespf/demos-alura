module JobsHelper

  def job_title(job)
    title = h(job.title)
    job.premium ? title + content_tag(:strong, " (premium)") : title
  end

end
